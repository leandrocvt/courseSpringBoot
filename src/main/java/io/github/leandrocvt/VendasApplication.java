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
    public CommandLineRunner init(@Autowired ClientRepository clientRepository) {
        return args -> {
            System.out.println("Salvando CLientes");
            clientRepository.save(new ClientModel("Fulano"));
            clientRepository.save(new ClientModel("Outro client"));

            List<ClientModel> result = clientRepository.findByName("Leandro");
            result.forEach(System.out::println);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);

    }
}
