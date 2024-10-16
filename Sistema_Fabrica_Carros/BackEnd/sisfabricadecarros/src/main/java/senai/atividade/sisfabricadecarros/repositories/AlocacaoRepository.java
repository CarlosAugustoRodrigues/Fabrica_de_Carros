package senai.atividade.sisfabricadecarros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import senai.atividade.sisfabricadecarros.entities.Alocacao;
import senai.atividade.sisfabricadecarros.entities.Automovel;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlocacaoRepository extends JpaRepository<Alocacao, Long> {
    @Query("SELECT al FROM Alocacao al WHERE area = :id")
    List<Alocacao> findByArea(@Param("id") Long id);

    @Query("SELECT al FROM Alocacao al WHERE area = :id AND automovel = :automovel")
    Alocacao findByAreaAutomovel(@Param("id") Long id, @Param("automovel") Automovel automovel);
}
