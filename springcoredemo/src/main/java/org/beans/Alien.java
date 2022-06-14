package org.beans;

import org.springframework.stereotype.Component;

@Component
public class Alien {
    private int alienId;
    private String alienName;

    public int getAlienId() {
        return alienId;
    }

    public void setAlienId(int alienId) {
        this.alienId = alienId;
    }

    public String getAlienName() {
        return alienName;
    }

    public void setAlienName(String alienName) {
        this.alienName = alienName;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "alienId=" + alienId +
                ", alienName='" + alienName + '\'' +
                '}';
    }
}
