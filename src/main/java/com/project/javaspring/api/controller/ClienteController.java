package com.project.javaspring.api.controller;

import com.project.javaspring.domain.model.Cliente;
import com.project.javaspring.domain.repository.ClienteRepository;
import com.project.javaspring.domain.service.CatalogoClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes") //em vez de usar a requisição /clientes em cada requisição
public class ClienteController {

    private ClienteRepository clienteRepository;
    private CatalogoClienteService catalogoClienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}") //definir a busca do por id
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
        return clienteRepository.findById(clienteId)
                .map(ResponseEntity::ok) //se caso existir 200 OK
                .orElse(ResponseEntity.notFound().build()); //senão 404
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //definir como resposta 201
    public  Cliente adicionar(@Valid @RequestBody Cliente cliente){ //vinculando o corpo da requisição com o argumento cliente
        return catalogoClienteService.salvar(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId,@Valid @RequestBody Cliente cliente){
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId); //para identificar que tem um id para atualizar em vez criar um novo
        cliente = catalogoClienteService.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable  Long clienteId){
        if (!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }

        catalogoClienteService.excluir(clienteId);

        return ResponseEntity.noContent().build();
    }

}
