package br.com.zup.pagamentos.boleto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer agencia;

    private Long numero;

    private Long codigo;

    private Long valor;

    private Boolean pago = false;

    private LocalDateTime dataPagamento = LocalDateTime.now();

    public Pagamento(){
    }

    public Pagamento(Integer agencia, Long numero, Long codigo, Long valor) {
        this.agencia = agencia;
        this.numero = numero;
        this.codigo = codigo;
        this.valor = valor;
    }

    public void pago() {
        pago = true;
    }
}
