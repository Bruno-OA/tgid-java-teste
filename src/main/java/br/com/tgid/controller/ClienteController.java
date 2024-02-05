package br.com.tgid.controller;

import br.com.tgid.entity.Cliente;
import br.com.tgid.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    List<Cliente> criar(Cliente cliente) {
        return clienteService.criar(cliente);
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
