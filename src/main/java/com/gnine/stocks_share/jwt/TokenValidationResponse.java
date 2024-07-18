package com.gnine.stocks_share.jwt;

public class TokenValidationResponse {
    private boolean valid;
    private String username;
    private String email; 

    public TokenValidationResponse(boolean valid, String username, String email) {
        this.valid = valid;
        this.username = username;
        this.email = email;
    }

    
    public boolean isValid() {
        return valid;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

