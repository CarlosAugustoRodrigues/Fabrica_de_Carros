package senai.atividade.sisfabricadecarros.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senai.atividade.sisfabricadecarros.entities.Concessionaria;
import senai.atividade.sisfabricadecarros.repositories.ConcessionariaRepository;

import java.util.List;

@RestController
@RequestMapping("/concessionaria")
public class ConcessionariaControllers {

    private final ConcessionariaRepository concessionariaRepository;

    public ConcessionariaControllers(ConcessionariaRepository concessionariaRepository) {
        this.concessionariaRepository = concessionariaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Concessionaria>> readAll() {
        List<Concessionaria> listaConcessionarias = concessionariaRepository.findAll();

        return ResponseEntity.ok(listaConcessionarias);
    }
}
