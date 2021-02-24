package br.com.zup.banco.conta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaRepository contaRepository;

    @GetMapping("/saldo")
    public ResponseEntity<ContaResponse> verificaSaldo(@RequestParam("agencia") Integer agencia,
                                               @RequestParam("numero") Long numero){

        Optional<Conta> conta = contaRepository.findByAgenciaAndNumero(agencia,
                numero);

        if(conta.isPresent()){
         return ResponseEntity.ok(ContaResponse.converte(conta.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/debita")
    @Transactional
    public ResponseEntity<ContaResponse> debita(@RequestBody DebitaContaRequest debitaContaRequest){
        Optional<Conta> contaOptional = contaRepository.findByAgenciaAndNumero(debitaContaRequest.getAgencia(),
                debitaContaRequest.getNumero());

        if(contaOptional.isPresent()){
            Conta conta = contaOptional.get();
            conta.setSaldo(conta.getSaldo()-debitaContaRequest.getValor());
            return ResponseEntity.ok(ContaResponse.converte(conta));
        }
        return ResponseEntity.notFound().build();

    }
}
