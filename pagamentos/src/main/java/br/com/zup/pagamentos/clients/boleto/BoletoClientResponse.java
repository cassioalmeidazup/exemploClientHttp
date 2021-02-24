package br.com.zup.pagamentos.clients.boleto;

public class BoletoClientResponse {

    private Long codigo;

    private Long valor;

    private Boolean pago;

    public Long getCodigo() {
        return codigo;
    }

    public Long getValor() {
        return valor;
    }

    public Boolean getPago() {
        return pago;
    }

    @Override
    public String toString() {
        return "BoletoClientResponse{" +
                "codigo=" + codigo +
                ", valor=" + valor +
                ", pago=" + pago +
                '}';
    }
}
