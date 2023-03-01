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

}
