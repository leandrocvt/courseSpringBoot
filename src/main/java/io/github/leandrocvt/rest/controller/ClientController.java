package io.github.leandrocvt.rest.controller;

import io.github.leandrocvt.domain.entities.ClientModel;
import io.github.leandrocvt.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

}
