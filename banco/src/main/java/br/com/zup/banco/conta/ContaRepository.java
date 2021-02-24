package br.com.zup.banco.conta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    public Optional<Conta> findByAgenciaAndNumero(Integer agencia, Long numero);
}
