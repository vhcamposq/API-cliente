package io.github.vhcamposq.cliente.model.repository;

import io.github.vhcamposq.cliente.model.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
