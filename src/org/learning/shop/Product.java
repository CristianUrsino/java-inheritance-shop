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

    protected BigDecimal discount = new BigDecimal(0.02);
    private boolean isRegistered;

    //costruttori
    public Product(String name, String brand, BigDecimal price, BigDecimal vat, boolean isRegistered) {
        productCode = generateProductCode();
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.vat = vat;
        this.isRegistered = isRegistered;
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
        if(!isRegistered){
            //se non registrato ritorno il prezzo
            return price.multiply(BigDecimal.ONE.add(vat));
        }
        else{
            //altrimenti
            return calculateDiscount().multiply(BigDecimal.ONE.add(vat));
        }
    }
    public String getInfo(){
        //se registrato creo un testo extra da ritornare
        String discountText = "";
        if(this.isRegistered){
            discountText =
                    "\n\tdiscount: " + discount.setScale(2,BigDecimal.ROUND_HALF_UP) +
                    "\n\tprice discounted: " + calculateDiscount().setScale(2,BigDecimal.ROUND_HALF_UP);
        }
        //ritorno le informazioni formattate
        return String.format("%08d",productCode) + "-" + name + ": " +
                "\n\tbrand: " + brand +
                "\n\tprice: " + price +
                (isRegistered ? discountText : "") +
                "\n\tvat: " + vat +
                "\n\tfull price: " + getTotalPrice().setScale(2,BigDecimal.ROUND_HALF_UP);
    }
    private BigDecimal calculateDiscount(){
        if(!isRegistered){
            //se l'utente non è registrato mando un output di errore e ritorno il prezzo normale
            System.out.println("Error you aren't registered");
            return price;
        }else {
            //prezzo * 1-sconto //(100 * 0.98)
            return price.multiply(BigDecimal.ONE.subtract(discount));
        }
    }
}
