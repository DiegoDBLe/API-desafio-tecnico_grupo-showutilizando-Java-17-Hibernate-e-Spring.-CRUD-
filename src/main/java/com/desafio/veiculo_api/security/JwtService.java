package com.desafio.veiculo_api.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    private Key getSigningKey() {
       
    	return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
   
    }

    public String gerarToken(String username) {
       
    	Date agora = new Date();
        Date dataExpiracao = new Date(agora.getTime() + expiration);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(agora)
                .setExpiration(dataExpiracao)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
  
    }

    public String extrairUsername(String token) {
        
    	return getClaims(token).getSubject();
    
    }

    public boolean tokenValido(String token) {
        try {
            
        	getClaims(token);
            
        	return true;
       
        } catch (Exception e) {
           
        	return false;
        
        }
    }

    private Claims getClaims(String token) {
        
    	return Jwts.parserBuilder().setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
