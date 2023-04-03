package io.github.leandrocvt.security.jwt;

import io.github.leandrocvt.VendasApplication;
import io.github.leandrocvt.domain.entities.UserModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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

    public Claims getClaims(String token) throws ExpiredJwtException     {
        return Jwts
                .parser()
                .setSigningKey(signatureKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validToken( String token) {
        try {
            Claims claims = getClaims(token);
            Date dateExpiration = claims.getExpiration();
            LocalDateTime dateTime = dateExpiration.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

            return !LocalDateTime.now().isAfter(dateTime);

        }catch (Exception e){
            return false;
        }
    }

    public String getUserLogin(String token) throws ExpiredJwtException {
        return (String) getClaims(token).getSubject();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(VendasApplication.class);
        JwtService service = context.getBean(JwtService.class);
        UserModel userModel = UserModel.builder().login("leandro").build();
        String token = service.generateToken(userModel);
        System.out.println(token);

        boolean isValidToken = service.validToken(token);
        System.out.println("Is the token valid? " + isValidToken);

        System.out.println(service.getUserLogin(token));
    }

}
