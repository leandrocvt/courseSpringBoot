package io.github.leandrocvt;

import io.github.leandrocvt.domain.entities.ClientModel;
import io.github.leandrocvt.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientRepository){
        return args -> {
            System.out.println("Salvando CLientes");
            clientRepository.save(new ClientModel("Leandro"));
            clientRepository.save(new ClientModel("Outro client"));

            List<ClientModel> allClients = clientRepository.allClients();
            allClients.forEach(System.out::println);

            System.out.println("Atualizando CLientes");
            allClients.forEach(c -> {
                c.setName(c.getName() + " atualizado");
                clientRepository.update(c);
            });

            allClients = clientRepository.allClients();
            allClients.forEach(System.out::println);

            System.out.println("Buscando CLientes");
            clientRepository.findallName("cli").forEach(System.out::println);

//            System.out.println("Deletando CLientes");
//            clientRepository.allClients().forEach(c -> {
//                clientRepository.delete(c);
//            });

            allClients = clientRepository.allClients();
            if(allClients.isEmpty()){
                System.out.println("Nenhum cliente encontrado");
            }else{
                allClients.forEach(System.out::println);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);

    }
}
