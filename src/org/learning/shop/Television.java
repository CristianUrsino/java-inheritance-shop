package org.learning.shop;
//imports
import java.math.BigDecimal;

public class Television extends Product{
    //attribiti
    private BigDecimal dimensions;
    private Boolean smart;
    //costruttori
    public Television(String name, String brand, BigDecimal price, BigDecimal vat,boolean isRegistered, BigDecimal dimensions, Boolean smart) {
        super(name, brand, price, vat, isRegistered);
        this.dimensions = dimensions;
        this.smart = smart;
        if(!smart) discount = new BigDecimal(0.10);
    }
    //setter
    public void setDimensions(BigDecimal dimensions) {
        this.dimensions = dimensions;
    }
    public void setSmart(Boolean smart) {
        this.smart = smart;
    }
    //getter
    public BigDecimal getDimensions() {
        return dimensions;
    }
    public Boolean getSmart() {
        return smart;
    }
    //altri metodi
    public String getSmartText(){
        return smart ? "smart" : "not smart";
    }
    @Override
    public String getInfo(){
        return super.getInfo() + "\n\tdimensions: " + dimensions + "\n\tsmart: " + getSmartText();
    }
}
