package br.com.zup.pagamentos.clients.banco;

public class BancoClientResponse {

    private Integer agencia;

    private Long numero;

    private Long saldo;

    public Integer getAgencia() {
        return agencia;
    }

    public Long getNumero() {
        return numero;
    }

    public Long getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "BancoClientResponse{" +
                "agencia=" + agencia +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
