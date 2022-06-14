package org.aop.bean;

public class Account {

    private String name;
    private int aId;

    public Account() {
    }

    public Account(String name, int aId) {
        this.name = name;
        this.aId = aId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", aId=" + aId + '}';
    }
}
