package org.learning.shop;

import java.math.BigDecimal;

public class Headphone extends Product{
    //attributi
    private String color;
    private Boolean type;//0 wired, 1 wireless
    //costruttori
    public Headphone(String name, String brand, BigDecimal price, BigDecimal vat,Boolean isRegistered, String color, Boolean type) {
        super(name, brand, price, vat, isRegistered);
        this.color = color;
        this.type = type;
        if(!type) discount = new BigDecimal(0.07);
    }
    //setter
    public void setColor(String color) {
        this.color = color;
    }
    public void setType(Boolean type) {
        this.type = type;
    }
    //getter
    public String getColor() {
        return color;
    }
    public Boolean getType() {
        return type;
    }
    //altri metodi
    public String getTypeText(){
        return type ? "wired" : "wireless";
    }
    @Override
    public String getInfo(){
        return super.getInfo() + "\n\tcolor: " + color + "\n\ttype: " + getTypeText();
    }
}
