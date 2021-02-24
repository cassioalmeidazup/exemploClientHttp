package br.com.zup.banco.conta;

public class DebitaContaRequest {

    public Integer agencia;

    public Long numero;

    public Long valor;

    public Integer getAgencia() {
        return agencia;
    }

    public Long getNumero() {
        return numero;
    }

    public Long getValor() {
        return valor;
    }
}
