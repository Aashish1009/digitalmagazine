package com.cts.model;

public class Subscription {
    private int subscriptionId;
    private int userId;
    private int magazineId;
    private String subscriptionDate;
    private String expiryDate;
    private String status;

    public Subscription() {}

    public Subscription(int userId, int magazineId, String subscriptionDate, String expiryDate, String status) {
        this.userId = userId;
        this.magazineId = magazineId;
        this.subscriptionDate = subscriptionDate;
        this.expiryDate = expiryDate;
        this.status = status;
    }

    // Getters and Setters
    public int getSubscriptionId() { return subscriptionId; }
    public void setSubscriptionId(int subscriptionId) { this.subscriptionId = subscriptionId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getMagazineId() { return magazineId; }
    public void setMagazineId(int magazineId) { this.magazineId = magazineId; }

    public String getSubscriptionDate() { return subscriptionDate; }
    public void setSubscriptionDate(String subscriptionDate) { this.subscriptionDate = subscriptionDate; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Subscription{" +
                "subscriptionId=" + subscriptionId +
                ", userId=" + userId +
                ", magazineId=" + magazineId +
                ", subscriptionDate='" + subscriptionDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
