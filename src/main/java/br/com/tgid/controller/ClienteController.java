package br.com.tgid.controller;

import br.com.tgid.entity.Cliente;
import br.com.tgid.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    ResponseEntity<List<Cliente>> criar(@Valid @RequestBody Cliente cliente) {
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

            ex.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
        return errors;
    }
}
