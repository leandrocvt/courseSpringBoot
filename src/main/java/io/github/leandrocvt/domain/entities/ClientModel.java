package io.github.leandrocvt.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 100)
    @NotEmpty(message = "Name field is required!")
    private String name;

    @Column(name = "cpf", length = 11)
    @NotEmpty(message = "cpf field is required!")
    @CPF(message = "Provide a valid CPF!")
    private String cpf;

    @JsonIgnore
    @OneToMany( mappedBy = "client", fetch = FetchType.LAZY )
    private Set<OrderModel> orders;

    public ClientModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

}
