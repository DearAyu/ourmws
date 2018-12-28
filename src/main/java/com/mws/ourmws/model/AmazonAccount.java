package com.mws.ourmws.model;

public class AmazonAccount {
    private int amazonAccountId;
    private String amazonAccountName;
    private String accessKey;
    private String secretKey;
    private String appName;
    private String appVersion;
    private String bindEmail;

    public int getAmazonAccountId() {
        return amazonAccountId;
    }

    public void setAmazonAccountId(int amazonAccountId) {
        this.amazonAccountId = amazonAccountId;
    }

    public String getAmazonAccountName() {
        return amazonAccountName;
    }

    public void setAmazonAccountName(String amazonAccountName) {
        this.amazonAccountName = amazonAccountName;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getBindEmail() {
        return bindEmail;
    }

    public void setBindEmail(String bindEmail) {
        this.bindEmail = bindEmail;
    }
}
