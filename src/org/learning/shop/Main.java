package org.learning.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Mause" , "Tecknet" , BigDecimal.valueOf(15) , BigDecimal.valueOf(0.21));
        System.out.println(p1.getInfo());
        Smartphone sm1 = new Smartphone("A70","Samsung", BigDecimal.valueOf(200), BigDecimal.valueOf(0.21), 248);
        System.out.println(sm1.getInfo());


    }
}
