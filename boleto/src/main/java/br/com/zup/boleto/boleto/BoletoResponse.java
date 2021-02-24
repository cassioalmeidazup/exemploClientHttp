package br.com.zup.boleto.boleto;

public class BoletoResponse {

    private Long codigo;

    private Long valor;

    private Boolean pago;

    public BoletoResponse(Long codigo, Long valor, Boolean pago) {
        this.codigo = codigo;
        this.valor = valor;
        this.pago = pago;
    }

    public static BoletoResponse converte(Boleto boleto) {
        return new BoletoResponse(boleto.getCodigo(), boleto.getValor(), boleto.getPago());
    }

    public Long getCodigo() {
        return codigo;
    }

    public Long getValor() {
        return valor;
    }

    public Boolean getPago() {
        return pago;
    }
}
