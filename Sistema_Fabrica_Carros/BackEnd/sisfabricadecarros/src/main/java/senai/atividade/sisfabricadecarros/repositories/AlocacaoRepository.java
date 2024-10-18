package senai.atividade.sisfabricadecarros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import senai.atividade.sisfabricadecarros.entities.Alocacao;
import senai.atividade.sisfabricadecarros.entities.Automovel;
import senai.atividade.sisfabricadecarros.entities.Concessionaria;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlocacaoRepository extends JpaRepository<Alocacao, Long> {
    @Query("SELECT al FROM Alocacao al WHERE al.area = :area AND al.quantidade > 0")
    List<Alocacao> findByArea(@Param("area") Long id);

    @Query("SELECT al FROM Alocacao al WHERE al.area = :area AND al.automovel = :automovel")
    Alocacao findByAreaAutomovel(@Param("area") Long area, @Param("automovel") Automovel automovel);

    @Query("SELECT al.concessionaria FROM Alocacao al WHERE al.area = :area AND al.automovel.modelo LIKE CONCAT('%', :modelo, '%')")
    List<Concessionaria> findConcessionaria(@Param("area") Long area, @Param("modelo") String modelo);
}
