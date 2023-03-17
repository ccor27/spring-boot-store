package com.api.store.model.dto;

public class CustomerAuthenticateResponse {
    private  String token;

    public CustomerAuthenticateResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
