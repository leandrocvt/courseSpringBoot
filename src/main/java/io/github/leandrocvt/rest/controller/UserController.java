package io.github.leandrocvt.rest.controller;

import io.github.leandrocvt.domain.entities.UserModel;
import io.github.leandrocvt.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel save(@RequestBody @Valid UserModel userModel){
        String encryptedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encryptedPassword);
        return userService.save(userModel);
    }

}
