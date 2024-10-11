package senai.atividade.sisfabricadecarros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senai.atividade.sisfabricadecarros.entities.Concessionaria;

@Repository
public interface ConcessionariaRepository extends JpaRepository<Concessionaria, Long> {
}
