package br.com.zup.pagamentos.clients.banco;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="bancoCliente", url="http://localhost:8082/contas")
public interface BancoClient {

    @PutMapping("/debita")
    @Headers("Content-Type : application/json")
    BancoClientResponse debitaConta(DebitoClientRequest debitoClientRequest);

    @GetMapping("/saldo")
    BancoClientResponse pegarDados(@RequestParam("agencia") Integer agencia, @RequestParam("numero") Long numero);
}
