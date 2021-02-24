package br.com.zup.banco.conta;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Conta {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer agencia;

    private Long numero;

    private Long saldo;

    public Long getId() {
        return id;
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

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }
}
