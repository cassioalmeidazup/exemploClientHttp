package br.com.zup.pagamentos.boleto;

import br.com.zup.pagamentos.clients.banco.BancoClient;
import br.com.zup.pagamentos.clients.banco.BancoClientResponse;
import br.com.zup.pagamentos.clients.banco.DebitoClientRequest;
import br.com.zup.pagamentos.clients.boleto.BoletoClient;
import br.com.zup.pagamentos.clients.boleto.BoletoClientRequest;
import br.com.zup.pagamentos.clients.boleto.BoletoClientResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pagamentos")
public class BoletosController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private BancoClient bancoClient;

    @Autowired
    private BoletoClient boletoClient;

    @PostMapping("/pagaBoleto")
    @Transactional
    public void paga(@RequestBody @Valid PagaBoletoRequest pagaBoletoRequest){

        //pega dados do boleto

//        RestTemplate restTemplate = new RestTemplate();
//        URI boletoUrl = UriComponentsBuilder.fromHttpUrl("http://localhost:8081/boletos/")
//                .pathSegment(pagaBoletoRequest.getCodigo().toString()).buildAndExpand().toUri();
//        ResponseEntity<BoletoClientResponse> teste = restTemplate.getForEntity(boletoUrl, BoletoClientResponse.class);
//        BoletoClientResponse boletoResponse = restTemplate.getForObject(boletoUrl,BoletoClientResponse.class);

        BoletoClientResponse boletoResponse = boletoClient.valida(pagaBoletoRequest.getCodigo());

        //validar se boleto ja foi pago

        if(boletoResponse.getPago()) return;

        //pega dados da conta bancaria
//        URI uri = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/contas/saldo")
//                .queryParam("agencia", pagaBoletoRequest.getAgencia())
//                .queryParam("numero", pagaBoletoRequest.getNumero())
//                .build().toUri();
//
//        WebClient webClient = WebClient.create();
//        BancoClientResponse bancoResponse = webClient.get().uri(uri).retrieve().bodyToMono(BancoClientResponse.class).block();

        BancoClientResponse bancoResponse = bancoClient
                .pegarDados(pagaBoletoRequest.getAgencia(), pagaBoletoRequest.getNumero());


        // valida se pagamento é possivel
        if(bancoResponse.getSaldo() < boletoResponse.getValor()) return;

        // salva pagamento

        Pagamento pagamento = new Pagamento(bancoResponse.getAgencia(),
                bancoResponse.getNumero(),
                boletoResponse.getCodigo(),
                boletoResponse.getValor());

        pagamentoRepository.save(pagamento);

        // realiza debito na conta do cliente (openfeign)
        DebitoClientRequest request = new DebitoClientRequest(bancoResponse.getAgencia(), bancoResponse.getNumero(),
                boletoResponse.getValor());

        BancoClientResponse bancoClientResponse = bancoClient.debitaConta(request);

        //realiza atualização do boleto no sistema de boletos

        BoletoClientResponse boletoClientResponse = boletoClient.atualiza(new BoletoClientRequest(pagaBoletoRequest.getCodigo()));

        pagamento.pago();

    }

}
