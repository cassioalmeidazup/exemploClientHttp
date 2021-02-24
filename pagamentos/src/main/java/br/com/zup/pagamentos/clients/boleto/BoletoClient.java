package br.com.zup.pagamentos.clients.boleto;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="boletoClient", url="http://localhost:8081/boletos")
public interface BoletoClient {

    @PutMapping("/paga")
    @Headers("Content-Type : application/json")
    BoletoClientResponse atualiza(BoletoClientRequest request);

    @GetMapping("/{codigo}")
    @Headers("Content-Type : application/json")
    BoletoClientResponse valida(@PathVariable("codigo") Long codigo);
}
