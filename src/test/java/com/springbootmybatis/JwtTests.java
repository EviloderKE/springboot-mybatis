package com.springbootmybatis;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;

@Slf4j
public class JwtTests {

    @Test
    void jwtWithHS256(){
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jws = Jwts.builder()
                .claim("name", "zk")
                .setHeaderParam("type", "jwt")
                .setSubject("Joe")
                .signWith(key)
                .compact();

        System.out.println(jws);

        // 验证
        String subject = null;
        try {
            subject = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws).getBody().getSubject();
            Object name = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jws).getBody().get("name");
            System.out.println(name);
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (JwtException e) {
            e.printStackTrace();
        }

        System.out.println(subject);
    }

    @Test
    void jwtWithRS256(){

        /**
         * 提前生成好公钥私钥
         */
        KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);

        // 私钥加密
        PrivateKey aPrivate = keyPair.getPrivate();

        String jws = Jwts.builder()
                .setSubject("Joe")
                .signWith(aPrivate)
                .compact();

        System.out.println(jws);

        String subject = Jwts.parserBuilder().setSigningKey(keyPair.getPublic()).build().parseClaimsJws(jws).getBody().getSubject();

        System.out.println(subject);

    }

}
