package org.beans;

public class Phones {
    private int phoneId;
    private String phoneBrand;
    private String price;

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phones{" +
                "phoneId=" + phoneId +
                ", phoneBrand='" + phoneBrand + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}

