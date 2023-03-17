package io.github.leandrocvt.rest.controller;

import io.github.leandrocvt.domain.entities.ClientModel;
import io.github.leandrocvt.repository.ClientRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("{id}")
    public ClientModel findById(@PathVariable Integer id){
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found!"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel save(@RequestBody @Valid ClientModel clientModel){
        return clientRepository.save(clientModel);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        clientRepository.findById(id).map( clientModel -> {
            clientRepository.delete(clientModel);
            return clientModel;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found!"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody @Valid ClientModel clientModel){
        clientRepository.findById(id).map( clientExist -> { clientModel.setId(clientExist.getId());
            clientRepository.save(clientModel);
            return clientExist;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found!"));
    }

    @GetMapping
    public List<ClientModel> find(ClientModel filterClient){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filterClient, matcher);
        return clientRepository.findAll(example);
    }

}
