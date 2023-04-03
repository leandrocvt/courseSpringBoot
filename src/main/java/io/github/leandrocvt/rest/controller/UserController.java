package io.github.leandrocvt.rest.controller;

import io.github.leandrocvt.domain.entities.UserModel;
import io.github.leandrocvt.exception.InvalidPasswordException;
import io.github.leandrocvt.rest.dto.CredentialsDTO;
import io.github.leandrocvt.rest.dto.TokenDTO;
import io.github.leandrocvt.security.jwt.JwtService;
import io.github.leandrocvt.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel save(@RequestBody @Valid UserModel userModel){
        String encryptedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encryptedPassword);
        return userService.save(userModel);
    }

    @PostMapping("/auth")
    public TokenDTO authenticate(@RequestBody CredentialsDTO credentialsDTO){
        try {
             UserModel userModel = UserModel.builder()
                            .login(credentialsDTO.getLogin())
                            .password(credentialsDTO.getPassword())
                            .build();
             UserDetails authenticateUser = userService.authenticate(userModel);
             String token = jwtService.generateToken(userModel);
             return new TokenDTO(userModel.getLogin(), token);
        }catch (UsernameNotFoundException | InvalidPasswordException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
