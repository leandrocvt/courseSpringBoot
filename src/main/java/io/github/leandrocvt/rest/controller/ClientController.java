package io.github.leandrocvt.rest.controller;

import io.github.leandrocvt.domain.entities.ClientModel;
import io.github.leandrocvt.repository.ClientRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/clients")
public class ClientController {

    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity findById(@PathVariable Integer id){
        Optional<ClientModel> clientModel = clientRepository.findById(id);

        if (clientModel.isPresent()){
            return ResponseEntity.ok(clientModel.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity save( @RequestBody ClientModel clientModel){
        ClientModel clientSave = clientRepository.save(clientModel);
        return ResponseEntity.ok(clientSave);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id){
        Optional<ClientModel> clientModel = clientRepository.findById(id);

        if (clientModel.isPresent()){
            clientRepository.delete(clientModel.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id, @RequestBody ClientModel clientModel){
        return clientRepository.findById(id).map( clientExist -> { clientModel.setId(clientExist.getId());
            clientRepository.save(clientModel);
            return ResponseEntity.noContent().build();
        }).orElseGet( () -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity find(ClientModel filterClient){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filterClient, matcher);
        List<ClientModel> listClients = clientRepository.findAll(example);
        return ResponseEntity.ok(listClients);
        
    }

}
