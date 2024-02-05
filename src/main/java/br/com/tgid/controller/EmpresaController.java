package br.com.tgid.controller;

import br.com.tgid.entity.Empresa;
import br.com.tgid.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    ResponseEntity<List<Empresa>> criar(@RequestBody Empresa empresa) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(empresaService.criar(empresa));
    }

    List<Empresa> listar() {
        return empresaService.listar();
    }

    List<Empresa> atualizar(@RequestBody Empresa empresa) {
        return empresaService.atualizar(empresa);
    }

    @DeleteMapping("{id}")
    List<Empresa> deletar(@PathVariable("id") Long id) {
        return empresaService.deletar(id);
    }
}
