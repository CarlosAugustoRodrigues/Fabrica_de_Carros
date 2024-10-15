package senai.atividade.sisfabricadecarros.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senai.atividade.sisfabricadecarros.entities.Automovel;
import senai.atividade.sisfabricadecarros.repositories.AutomovelRepository;

import java.util.List;

@RestController
@RequestMapping("/automovel")
public class AutomovelControllers {

    private final AutomovelRepository automovelRepository;

    public AutomovelControllers(AutomovelRepository automovelRepository) {
        this.automovelRepository = automovelRepository;
    }

    @GetMapping
    public ResponseEntity<List<Automovel>> readAll() {
        List<Automovel> listaAutomoveis = automovelRepository.findAll();

        return ResponseEntity.ok(listaAutomoveis);
    }
}
