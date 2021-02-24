package br.com.zup.boleto.boleto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoletoRepository extends JpaRepository<Boleto, Long> {

    public Optional<Boleto> findByCodigo(Long codigo);
}
