package io.github.leandrocvt.service.impl;

import io.github.leandrocvt.domain.entities.UserModel;
import io.github.leandrocvt.exception.InvalidPasswordException;
import io.github.leandrocvt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    public UserDetails authenticate(UserModel userModel){
       UserDetails user = loadUserByUsername(userModel.getLogin());
       boolean samePasswords = encoder.matches(userModel.getPassword(), user.getPassword());

       if (samePasswords){
           return user;
       }
       throw new InvalidPasswordException();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found in database!"));

        String [] roles = userModel.isAdmin() ? new String[]{"ADMIN", "USER"}
                : new String[] {"USER"};

        return User.builder()
                .username(userModel.getLogin())
                .password(userModel.getPassword())
                .roles(roles)
                .build();
    }
}
