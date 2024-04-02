package org.learning.shop;
//imports
import java.math.BigInteger;
import java.util.Random;
import java.math.BigDecimal;

public class Smartphone extends Product{
    //attrubuti
    private BigInteger imei;
    private int memory;
    //costruttori
    public Smartphone(String name, String brand, BigDecimal price, BigDecimal vat, int memory) {
        super(name, brand, price, vat);
        imei = generateImei();
        this.memory = memory;
    }
    //metodi per il costruttore
    private BigInteger generateImei(){
        Random generateRandom = new Random();
        long tempImei;
        do{
            //cicla finchè non è positivo
            //nextLong genera un numero troppo lungo, %1... per limitarlo, + 1... per dare un minimo
            tempImei = 100000000000000L + generateRandom.nextLong() % 10000000000000L;
        }while(tempImei<0);
        return BigInteger.valueOf(tempImei);
    }
    //setter
    public void setMemory(int memory) {
        this.memory = memory;
    }
    //getter
    public BigInteger getImei() {
        return imei;
    }
    public int getMemory() {
        return memory;
    }
    //altri metodi
    public String getInfo(){
        return super.getInfo() + "\n\timei: " + imei + "\n\tmemory: " + memory;
    }
}
