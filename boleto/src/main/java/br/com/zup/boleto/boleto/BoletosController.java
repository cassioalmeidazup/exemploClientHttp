package br.com.zup.boleto.boleto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/boletos")
@RestController
public class BoletosController {

    @Autowired
    private BoletoRepository boletoRepository;

    @GetMapping("/{codigo}")
    public ResponseEntity<BoletoResponse> valida(@PathVariable("codigo") @Valid Long codigo, UriComponentsBuilder uriComponentsBuilder){

        Optional<Boleto> boleto = boletoRepository.findByCodigo(codigo);

        if(boleto.isPresent()) {
            return ResponseEntity.ok()
                    .location(uriComponentsBuilder.path("/boletos/{codigo}")
                            .buildAndExpand(codigo).toUri())
                    .body(BoletoResponse.converte(boleto.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/paga")
    @Transactional
    public ResponseEntity<BoletoResponse> paga(@RequestBody @Valid BoletoRequest boletoRequest){

        Optional<Boleto> boleto = boletoRepository.findByCodigo(boletoRequest.getCodigo());

        if(boleto.isPresent()){
            Boleto bol = boleto.get();
            bol.setPago(true);
            return ResponseEntity.ok(BoletoResponse.converte(bol));
        }
        return ResponseEntity.notFound().build();
    }


}
