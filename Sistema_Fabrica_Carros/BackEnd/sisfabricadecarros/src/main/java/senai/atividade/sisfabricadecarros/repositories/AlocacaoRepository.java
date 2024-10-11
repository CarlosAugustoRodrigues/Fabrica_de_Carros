package senai.atividade.sisfabricadecarros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senai.atividade.sisfabricadecarros.entities.Alocacao;

@Repository
public interface AlocacaoRepository extends JpaRepository<Alocacao, Long> {
}
