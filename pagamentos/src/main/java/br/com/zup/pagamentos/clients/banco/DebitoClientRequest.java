package br.com.zup.pagamentos.clients.banco;

public class DebitoClientRequest {

    private Integer agencia;

    private Long numero;

    private Long valor;

    public DebitoClientRequest(Integer agencia, Long numero, Long valor) {
        this.agencia = agencia;
        this.numero = numero;
        this.valor = valor;
    }

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
