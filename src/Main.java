

import Others.Address;
import Others.Order;
import Others.Review;
import Others.User;
import Products.Book;
import Products.Clothing;
import Products.Electronics;
import Products.Product;
import Read_Write.Read_Write;
import Service.Service;
import Utile.OrderStatus;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static  Service service = new Service();

    public static void main(String[] args) {
        Address.CSVWriter();
        Product.CSVWriter();
        User.CSVWriter();
        Order.CSVWriter();
        Review.CSVWriter();

        Product carte = new Book(1, "Narnia", 50);
        Product pantaloni = new Clothing(2, "Jeans", 100);
        Product laptop = new Electronics(3, "Laptop", 2000);
        service.adaugaProdus(carte);
        service.adaugaProdus(pantaloni);
        service.adaugaProdus(laptop);
        Address adresa1=new Address("Venus","Bucuresti","Romania","1456RO");
        Address adresa2=new Address("Fahrzig","Berlin","Germania","143DE");
        Address adresa3=new Address("Greenland","London","England","1456ENG");
        service.adaugaAdresa(adresa1);
        service.adaugaAdresa(adresa2);
        service.adaugaAdresa(adresa3);
        User user1=new User("Daniel","daniel02@gmail.com","12345678",adresa1);
        User user2=new User("Andrei","andrei49@gmail.com","abcde",adresa2);
        User user3=new User("Alex","alex40@gmail.com","qwerty",adresa3);
        service.adaugaUtilizator(user1);
        service.adaugaUtilizator(user2);
        service.adaugaUtilizator(user3);
        Order comanda1=new Order(1,adresa1, OrderStatus.PLACED);
        comanda1.addProduct(carte);
        comanda1.addProduct(pantaloni);
        Order comanda2=new Order(2,adresa2,OrderStatus.PLACED);
        comanda2.addProduct(laptop);
        comanda2.addProduct(pantaloni);
        service.adaugaComanda(comanda1);
        service.adaugaComanda(comanda2);
        Review review1=new Review("Foarte buna",5);
        Review review2=new Review("Buna",4);
        service.adaugaRecenzielaProdus(carte,review1);
        service.adaugaRecenzielaProdus(carte,review2);
        service.adaugaRecenzielaProdus(pantaloni,review1);
        service.stergeRecenzielaProdus(carte,review1);
        service.stergeUtilizator(user2);
        service.stergeProdus(carte);
        System.out.println(service.cautaProdusDupaDenumire("Laptop").getPrice());
        for (Product produs:service.getListaProduse()) {
            System.out.println(produs.getName());
        }



    }

}
