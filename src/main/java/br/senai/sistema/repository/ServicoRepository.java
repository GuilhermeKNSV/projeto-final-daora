
package br.senai.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.senai.sistema.model.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
