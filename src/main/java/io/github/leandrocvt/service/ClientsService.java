package io.github.leandrocvt.service;

import io.github.leandrocvt.model.Client;
import io.github.leandrocvt.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsService {

    @Autowired
    private ClientsRepository repository;

    public void saveClient(Client client){
        validarClient(client);
        this.repository.save(client);
    }

    public void validarClient(Client client){

    }
}
