package br.com.zup.pagamentos.clients.boleto;

public class BoletoClientRequest {

    private Long codigo;

    public BoletoClientRequest(Long codigo) {
        this.codigo = codigo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}
