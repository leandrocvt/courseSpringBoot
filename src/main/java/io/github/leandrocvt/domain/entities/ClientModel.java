package io.github.leandrocvt.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "client")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @OneToMany( mappedBy = "client" )
    private Set<OrderModel> orders;

    public ClientModel(String name) {
        this.name = name;
    }

    public ClientModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
