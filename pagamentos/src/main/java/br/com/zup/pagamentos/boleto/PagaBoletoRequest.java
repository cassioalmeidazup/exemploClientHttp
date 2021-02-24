package br.com.zup.pagamentos.boleto;

import javax.validation.constraints.NotNull;

public class PagaBoletoRequest {

    @NotNull
    private Integer agencia;

    @NotNull
    private Long numero;

    @NotNull
    private Long codigo;

    public Integer getAgencia() {
        return agencia;
    }

    public Long getNumero() {
        return numero;
    }

    public Long getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "PagaBoletoRequest{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", codigo=" + codigo +
                '}';
    }
}
