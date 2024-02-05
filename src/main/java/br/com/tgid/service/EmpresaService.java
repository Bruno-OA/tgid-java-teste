package br.com.tgid.service;

import br.com.tgid.entity.Empresa;
import br.com.tgid.repository.EmpresaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {
    private EmpresaRepository  empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> criar(Empresa empresa) {
        empresaRepository.save(empresa);
        return listar();
    }

    public List<Empresa> listar() {
        Sort sort = Sort.by("nome").descending();
        return empresaRepository.findAll(sort);
    }

    public List<Empresa> atualizar(Empresa empresa) {
        empresaRepository.save(empresa);
        return listar();
    }

    public List<Empresa> deletar(Long id) {
        empresaRepository.deleteById(id);
        return listar();
    }
}
