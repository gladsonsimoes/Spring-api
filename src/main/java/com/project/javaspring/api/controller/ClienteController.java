package com.project.javaspring.api.controller;

import com.project.javaspring.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Gladson");
        cliente1.setEmail("gladsonssimoes@email.com");
        cliente1.setTelefone("5559888777");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Joao");
        cliente2.setEmail("joao@email.com");
        cliente2.setTelefone("5559866667");

        return Arrays.asList(cliente1 , cliente2);
    }
}
