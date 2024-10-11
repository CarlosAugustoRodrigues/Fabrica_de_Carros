package senai.atividade.sisfabricadecarros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senai.atividade.sisfabricadecarros.entities.Automovel;

@Repository
public interface AutomovelRepository extends JpaRepository<Automovel, Long> {
}
