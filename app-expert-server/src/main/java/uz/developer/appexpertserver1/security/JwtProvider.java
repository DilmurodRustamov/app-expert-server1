package uz.developer.appexpertserver1.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtProvider {

    private String secKey = "kerklikey";

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+1000*50))
                .signWith(SignatureAlgorithm.HS512,secKey)
                .compact();
    }
}
