package com.mws.ourmws.model;

public class EmailAccount {
    private int emailAccountId;
    private String username;
    private String password;
    private String host;
    private int port;
    private int amazonAccountId;

    public int getEmailAccountId() {
        return emailAccountId;
    }

    public void setEmailAccountId(int emailAccountId) {
        this.emailAccountId = emailAccountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getAmazonAccountId() {
        return amazonAccountId;
    }

    public void setAmazonAccountId(int amazonAccountId) {
        this.amazonAccountId = amazonAccountId;
    }
}
