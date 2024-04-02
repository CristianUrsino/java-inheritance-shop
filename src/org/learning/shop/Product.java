package org.learning.shop;
//imports
import java.math.BigDecimal;
import java.util.Random;
public class Product {
    //attributi
    private int productCode;
    private String name;
    private String brand;
    private BigDecimal price;
    private BigDecimal vat;

    //costruttori
    public Product(String name, String brand, BigDecimal price, BigDecimal vat) {
        productCode = generateProductCode();
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.vat = vat;
    }
    //metodi per il costruttore
    private int generateProductCode(){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(99999999);
    }

    //getter
    public int getProductCode() {
        return productCode;
    }
    public String getName() {
        return name;
    }
    public String getbrand() {
        return brand;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public BigDecimal getVat() {
        return vat;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }
    public void setbrand(String brand) {
        this.brand = brand;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    //altri metodi
    public BigDecimal getTotalPrice(){
        //la formula è: price * (1 + iva)
        return price.multiply(BigDecimal.ONE.add(vat));
    }
    public String getInfo(){
        //ritorno codice-nome, ma il codice anche se di 4 cifre appare di 8 (es. 00001234)
        return String.format("%08d",productCode) + "-" + name + ": " +
                "\n\tbrand: " + brand +
                "\n\tprice: " + price +
                "\n\tvat: " + vat +
                "\n\tfull price: " + getTotalPrice();
    }
}
