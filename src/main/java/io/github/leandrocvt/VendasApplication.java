package io.github.leandrocvt;

import io.github.leandrocvt.domain.entities.ClientModel;
import io.github.leandrocvt.domain.entities.OrderModel;
import io.github.leandrocvt.repository.ClientRepository;
import io.github.leandrocvt.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired ClientRepository clientRepository,
            @Autowired OrderRepository orderRepository
    ) {
        return args -> {
            System.out.println("Salvando CLientes");
            ClientModel fulano = new ClientModel("Fulano");
            clientRepository.save(fulano);

            OrderModel p = new OrderModel();
            p.setClient(fulano);
            p.setOrderDate(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            orderRepository.save(p);

//            ClientModel client = clientRepository.findClientFetchOrderRepository(fulano.getId());
//            System.out.println(client);
//            System.out.println(client.getOrders());

            orderRepository.findByClient(fulano).forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);

    }
}
