package io.github.leandrocvt.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class ClientModel {

    private Integer id;
    private String name;

    public ClientModel(String name) {
        this.name = name;
    }

    public ClientModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
