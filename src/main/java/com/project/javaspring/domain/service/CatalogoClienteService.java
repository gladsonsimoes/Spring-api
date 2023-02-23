package com.project.javaspring.domain.service;

import com.project.javaspring.domain.model.Cliente;
import com.project.javaspring.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service //representa os serviços que serão executados onde colocamos regras de negocio
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    @Transactional //Se algo nesse metodo de errado toda transações serão descartadas do bancco de dados
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}
