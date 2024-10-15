package senai.atividade.sisfabricadecarros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import senai.atividade.sisfabricadecarros.entities.Alocacao;
import senai.atividade.sisfabricadecarros.entities.Automovel;

import java.util.List;

@Repository
public interface AlocacaoRepository extends JpaRepository<Alocacao, Long> {
    @Query("SELECT automovel a FROM Alocacao al WHERE area = :id")
    List<Automovel> findByArea(@Param("id") Long id);
}
