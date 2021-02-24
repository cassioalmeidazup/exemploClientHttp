package br.com.zup.banco.conta;

public class ContaResponse {

    private Integer agencia;

    private Long numero;

    private Long saldo;

    public ContaResponse(Integer agencia, Long numero, Long saldo) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    public static ContaResponse converte(Conta conta) {
        return new ContaResponse (conta.getAgencia(), conta.getNumero(), conta.getSaldo());
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Long getNumero() {
        return numero;
    }

    public Long getSaldo() {
        return saldo;
    }
}
