package br.com.tgid.service;

import br.com.tgid.entity.Cliente;
import br.com.tgid.repository.ClienteRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> criar(Cliente cliente) {
        clienteRepository.save(cliente);
        return listar();
    }

    public List<Cliente> listar() {
        Sort sort = Sort.by("nome").descending();
        return clienteRepository.findAll(sort);
    }

    public List<Cliente> atualizar(Cliente cliente) {
        clienteRepository.save(cliente);
        return listar();
    }

    public List<Cliente> deletar(Long id) {
        clienteRepository.deleteById(id);
        return listar();
    }

    public Optional<Cliente> buscarCpf(String cpf) {
        Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
        return cliente;
    }

}
