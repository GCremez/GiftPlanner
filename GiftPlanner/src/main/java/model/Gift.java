package model;

public class Gift {
    // TODO: Add fields and methods
    private int id;
    private String name;
    private String description;
    private double price;
    private boolean isPurchased;
    private int recipientId;
    private int occasionId;
    private int gifterId;

    public Gift() {} // default No-arg constructor

    public Gift(int id, String name, String description, double price, boolean isPurchased, int recipientId, int occasionId, int gifterId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isPurchased = isPurchased;
        this.recipientId = recipientId;
        this.occasionId = occasionId;
        this.gifterId = gifterId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {  
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPurchased() {
        return isPurchased;
    }

    public void setPurchased(boolean isPurchased) {
        this.isPurchased = isPurchased;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public int getOccasionId() {
        return occasionId;
    }

    public void setOccasionId(int occasionId) {
        this.occasionId = occasionId;
    }

    public int getGifterId() {
        return gifterId;
    }

    public void setGifterId(int gifterId) {
        this.gifterId = gifterId;
    }

    @Override
    public String toString() {
        return "Gift [ id=" + id 
        + ", name=" + name 
        + ", description=" + description 
        + ", price=" + price 
        + ", isPurchased=" + isPurchased 
        + ", recipientId=" + recipientId 
        + ", occasionId=" + occasionId 
        + ", gifterId=" + gifterId 
        + "]";
    }

} 