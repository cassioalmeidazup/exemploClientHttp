package br.com.zup.boleto.boleto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BoletoRequest {

    @NotNull @Min(1)
    private Long codigo;

    public Long getCodigo() {
        return codigo;
    }
}
