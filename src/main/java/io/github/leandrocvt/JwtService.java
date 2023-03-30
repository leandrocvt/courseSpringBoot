package io.github.leandrocvt;

import io.github.leandrocvt.domain.entities.UserModel;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value("${security.jwt.expiration}")
    private String expiration;

    @Value("{$security.jwt.signature-key}")
    private String signatureKey;

    public String generateToken(UserModel userModel){
        long expString = Long.valueOf(expiration);
        LocalDateTime dateTimeExpiration = LocalDateTime.now().plusMinutes(expString);
        Instant instant = dateTimeExpiration.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        return Jwts
                .builder()
                .setSubject(userModel.getLogin())
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, signatureKey )
                .compact();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(VendasApplication.class);
        JwtService service = context.getBean(JwtService.class);
        UserModel userModel = UserModel.builder().login("leandro").build();
        String token = service.generateToken(userModel);
        System.out.println(token);
    }

}
