package org.beans;

public class Iphone implements  Phone{
    private Phones phones;

    @Override
    public String getSpecifications() {
        return "Ram = 8gb , AndroidOS = IOS 14, Storage = 128gb , Price = 50000";
    }
}
