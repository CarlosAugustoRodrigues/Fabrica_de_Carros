package senai.atividade.sisfabricadecarros.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.atividade.sisfabricadecarros.entities.Alocacao;
import senai.atividade.sisfabricadecarros.entities.Automovel;
import senai.atividade.sisfabricadecarros.repositories.AlocacaoRepository;

import java.util.List;

@RestController
@RequestMapping("/alocacao")
public class AlocacaoControllers {

    private final AlocacaoRepository alocacaoRepository;

    public AlocacaoControllers(AlocacaoRepository alocacaoRepository) {
        this.alocacaoRepository = alocacaoRepository;
    }

    @GetMapping("/{area}")
    public ResponseEntity<List<Automovel>> readByArea(
            @PathVariable(value = "area") Long id
    ) {
        List<Automovel> listaAutomoveis = alocacaoRepository.findByArea(id);

        return ResponseEntity.ok(listaAutomoveis);
    }

    @GetMapping
    public ResponseEntity<List<Alocacao>> readAll() {
        List<Alocacao> listaAlocacoes = alocacaoRepository.findAll();

        return ResponseEntity.ok(listaAlocacoes);
    }

}
