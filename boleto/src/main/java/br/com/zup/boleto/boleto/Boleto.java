package br.com.zup.boleto.boleto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Boleto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long codigo;

    private Long valor;

    private Boolean pago;

    public Long getId() {
        return id;
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

    public void setPago(Boolean pago) {
        this.pago = pago;
    }
}
