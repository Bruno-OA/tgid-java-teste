package br.com.tgid.controller;

import br.com.tgid.entity.Cliente;
import br.com.tgid.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    ResponseEntity<List<Cliente>> criar( @RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(clienteService.criar(cliente));
    }

    @GetMapping
    List<Cliente> listar() {
        return clienteService.listar();
    }

    @PutMapping
    List<Cliente> atualizar(@RequestBody Cliente cliente) {
        return clienteService.atualizar(cliente);
    }

    @DeleteMapping("{id}")
    List<Cliente> deletar(@PathVariable("id") Long id) {
        return clienteService.deletar(id);
    }
}
