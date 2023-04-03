package io.github.leandrocvt.rest.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CredentialsDTO {
    private String login;
    private String password;
}
