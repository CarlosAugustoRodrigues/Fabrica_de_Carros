package senai.atividade.sisfabricadecarros.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.atividade.sisfabricadecarros.entities.Alocacao;
import senai.atividade.sisfabricadecarros.entities.Automovel;
import senai.atividade.sisfabricadecarros.repositories.AlocacaoRepository;
import senai.atividade.sisfabricadecarros.repositories.AutomovelRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alocacao")
public class AlocacaoControllers {

    private final AlocacaoRepository alocacaoRepository;
    private final AutomovelRepository automovelRepository;



    public AlocacaoControllers(AlocacaoRepository alocacaoRepository,
                               AutomovelRepository automovelRepository) {
        this.alocacaoRepository = alocacaoRepository;
        this.automovelRepository = automovelRepository;
    }

    @GetMapping("/{area}")
    public ResponseEntity<List<Alocacao>> readByArea(
            @PathVariable(value = "area") Long id
    ) {
        List<Alocacao> listaAlocacoes = alocacaoRepository.findByArea(id);

        return ResponseEntity.ok(listaAlocacoes);
    }

    @GetMapping
    public ResponseEntity<List<Alocacao>> readAll() {
        List<Alocacao> listaAlocacoes = alocacaoRepository.findAll();

        return ResponseEntity.ok(listaAlocacoes);
    }

    @PutMapping("/{area}/{automovel}")
    public ResponseEntity<?> updateQuantidade(
            @PathVariable(value = "area") Long area,
            @PathVariable(value = "automovel") Long automovel
    ) {
        var automovel0 = automovelRepository.findById(automovel);
        var alocacao0 = alocacaoRepository.findByAreaAutomovel(area, automovel0.get());

        if (alocacao0.getQuantidade() == 1) {
            deleteAlocacao(area, automovel);
            return ResponseEntity.ok("Alocação excluída com sucesso!");
        }

        alocacao0.setQuantidade(alocacao0.getQuantidade() - 1);
        alocacaoRepository.save(alocacao0);

        return ResponseEntity.status(HttpStatus.OK).body(alocacao0);
    }

    public ResponseEntity<?> deleteAlocacao(Long area, Long automovel) {
        var automovel0 = automovelRepository.findById(automovel);
        var alocacao0 = alocacaoRepository.findByAreaAutomovel(area, automovel0.get());

        alocacaoRepository.deleteById(alocacao0.getId());

        return ResponseEntity.ok("Alocação excluída com sucesso!");
    }

}
