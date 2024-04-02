package org.learning.shop;
//imports
import com.sun.org.apache.xalan.internal.xsltc.DOM;

import java.math.BigDecimal;
import java.util.Scanner;
public class Cart {
    public static void main(String[] args) {
        //definisco lo scanner
        Scanner scanner = new Scanner(System.in);
        //definisco la grandezza dell'array con validazione
        int sizeCart = 0;
        do{
            //ciclo finchè l'input di sizeCart non è un numero intero positivo
            try{
                System.out.print("how many product: ");
                sizeCart = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                //setto sizeCart a 0 per ripetere il ciclo
                sizeCart = 0;
            }
            if(sizeCart <= 0){
                //output messaggio di errore
                System.out.println("Error the size of cart must be a integer positive number, please try again");
            }
        }while(sizeCart <= 0);
        //dichiaro l'array di prodotti e la variabile per la scelta del tipo di prodotto
        Product[] cart = new Product[sizeCart];
        int typeProduct;
        //riempio l'array
        for(Product product : cart){
        //ciclo tutti i prodotti nel carrello
            //setto il typeProduct a 0
            typeProduct = 0;
            do{
                //ciclo finchè non viene inserito un numero valido
                try{
                    System.out.print("Digit 1 for smartphone, 2 for television, 3 for headphone: ");
                    typeProduct = Integer.parseInt(scanner.nextLine());
                }catch (Exception e){
                    //setto typeProduct a 0 per ripetere il ciclo
                    typeProduct = 0;
                }
                if(typeProduct <=0 || typeProduct > 3){
                    //output messaggio di errore
                    System.out.println("Error the number must be a integer positive number between 1 and 3, please try again");
                }
            }while(typeProduct <= 0 || typeProduct > 3);
            //dichiaro i campi temporanee
            String name, brand;
            BigDecimal price, vat;
            //le inizializzo in input con validazione
            do{
                //ciclo finchè la stringa NAME è piena
                System.out.print("Enter name: ");
                name = scanner.nextLine();
                if(name.isEmpty()){
                    //output errore
                    System.out.println("Error, field name is empty, please try again");
                }
            }while(name.isEmpty());
            do {
                //ciclo finchè la stringa BRAND è piena
                System.out.print("Enter brand: ");
                brand = scanner.nextLine();
                if(brand.isEmpty()){
                    //output errore
                    System.out.println("Error, field brand is empty, please try again");
                }
            }while(brand.isEmpty());
            do{
                //ciclo finchè il PREZZO è maggiore di 0
                try {
                    System.out.print("Enter price: ");
                    price = new BigDecimal(scanner.nextLine());
                }catch (Exception e){
                    //setto price a 0 per ripetere il ciclo
                    price = BigDecimal.ZERO;
                }
                if(price.compareTo(BigDecimal.ZERO) < 0){
                    //se price minore di 0 output errore
                    System.out.println("Error the field price must be a positive number, please try again");
                }
            }while(price.compareTo(BigDecimal.ZERO) < 0);
            do{
                //ciclo finchè l'IVA è maggiore di 0
                try {
                    System.out.print("Enter vat: ");
                    vat = new BigDecimal(scanner.nextLine());
                }catch (Exception e){
                    //setto price a 0 per ripetere il ciclo
                    vat = BigDecimal.ZERO;
                }
                if(vat.compareTo(BigDecimal.ZERO) < 0){
                    //se price minore di 0 output errore
                    System.out.println("Error the field vat must be a positive number, please try again");
                }
            }while(vat.compareTo(BigDecimal.ZERO) < 0);
            //in base alla scelta chiedo determinati campi ed inizializzo il prodotto
            switch (typeProduct){
                case 1:
                    //dichiaro i campi specifici temporanei
                    int memory = 0;
                    do {
                        try{
                            System.out.print("Enter memory: ");
                            memory = Integer.parseInt(scanner.nextLine());
                        }catch (Exception e){
                            //setto sizeCart a 0 per ripetere il ciclo
                            memory = 0;
                        }
                        if(memory <= 0){
                            //output messaggio di errore
                            System.out.println("Error the field memory must be a integer positive number, please try again");
                        }
                    }while (memory<0);
                    //inizializzo il prodotto con i dati forniti
                    product = new Smartphone(name,brand,price,vat,memory);
                    //stampo le informazioni del prodotto
                    System.out.println("\n" + product.getInfo() + "\n\n");
                    break;
                case 2:
                    //dichiaro i campi specifici temporanei
                    BigDecimal dimensions;
                    int smart; // int invece di boolean per velocizzare l'output
                    do{
                        //ciclo finchè la DIMENZIONE è maggiore di 0
                        try {
                            System.out.print("Enter dimensions: ");
                            dimensions = new BigDecimal(scanner.nextLine());
                        }catch (Exception e){
                            //setto la dimenzione a 0 per ripetere il ciclo
                            dimensions = BigDecimal.ZERO;
                        }
                        if(dimensions.compareTo(BigDecimal.ZERO) < 0){
                            //se dimensions minore di 0 output errore
                            System.out.println("Error the field dimensions must be a positive number, please try again");
                        }
                    }while(dimensions.compareTo(BigDecimal.ZERO) < 0);
                    do{
                        //ciclo finchè SMART non è 1 o 0
                        try{
                            System.out.print("Digit 0 if is not smart, 1 is smart: ");
                            smart = Integer.parseInt(scanner.nextLine());
                        }catch (Exception e){
                            //setto smart a 0 per ripetere il ciclo
                            smart = -1;
                        }
                        if(smart < 0 || smart > 1){
                            //output messaggio di errore
                            System.out.println("Error the number must be a integer positive number between 0 and 1, please try again");
                        }
                    }while(smart < 0 || smart > 1 );
                    //inizializzo il prodotto con i dati forniti
                    product = new Television(name,brand,price,vat,dimensions, smart != 0); //se diverso da 0 = 1
                    //stampo le informazioni del prodotto
                    System.out.println("\n" + product.getInfo() + "\n\n");
                    break;
                case 3:
                    //dichiaro i campi specifici temporanei
                    String color;
                    int type;
                    do {
                        //ciclo finchè la stringA COLOR è piena
                        System.out.print("Enter color: ");
                        color  = scanner.nextLine();
                        if(color.isEmpty()){
                            //output errore
                            System.out.println("Error, field color is empty, please try again");
                        }
                    }while(color.isEmpty());
                    do{
                        //ciclo finchè TYPE non è 1 o 0
                        try{
                            System.out.print("Digit 0 if is wired, 1 is wireless: ");
                            type = Integer.parseInt(scanner.nextLine());
                        }catch (Exception e){
                            //setto smart a 0 per ripetere il ciclo
                            type = -1;
                        }
                        if(type < 0 || type > 1){
                            //output messaggio di errore
                            System.out.println("Error the number must be a integer positive number between 0 and 1, please try again");
                        }
                    }while(type < 0 || type > 1 );
                    //inizializzo il prodotto con i dati forniti
                    product = new Headphone(name,brand,price,vat,color, type != 0); //se diverso da 0 = 1
                    //stampo le informazioni del prodotto
                    System.out.println("\n" + product.getInfo() + "\n\n");
                    break;
            }
        }
        //chiudo lo scanner
        scanner.close();
    }
}
