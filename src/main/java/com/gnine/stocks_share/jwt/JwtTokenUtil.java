package com.gnine.stocks_share.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtTokenUtil {
	private String secretKey = "hellocrsapplication";

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder().setClaims(claims).setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, secretKey).compact();
	}

	public TokenValidationResponse validateToken(String token) {
	    try {
	        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	        Date expiration = claims.getExpiration();
	        boolean isExpired = expiration.before(new Date());
	        String username = claims.getSubject();
	        String email = claims.get("email", String.class); 
	        return new TokenValidationResponse(!isExpired, username, email);
	    } catch (Exception e) {
	        return new TokenValidationResponse(false, null, null);
	    }
	}

	public boolean isTokenExpired(String token) {
		final Date expiration = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration();
		return expiration.before(new Date());
	}

	private String getUsernameFromToken(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}
}
