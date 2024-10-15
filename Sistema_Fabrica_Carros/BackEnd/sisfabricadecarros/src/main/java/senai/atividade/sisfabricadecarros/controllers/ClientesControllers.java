package senai.atividade.sisfabricadecarros.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import senai.atividade.sisfabricadecarros.entities.Cliente;
import senai.atividade.sisfabricadecarros.repositories.ClienteRepository;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClientesControllers {

    private final ClienteRepository clienteRepository;

    public ClientesControllers(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> readAll() {
        List<Cliente> listaClientes = clienteRepository.findAll();

        return ResponseEntity.ok(listaClientes);
    }
}
