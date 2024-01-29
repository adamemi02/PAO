

import Order_Product.Order_ProductRepository;
import Others.Address.Address;
import Others.Address.AddressRepository;
import Others.Order.Order;
import Others.Order.OrderRepository;
import Others.Review.Review;
import Others.Review.ReviewRepository;
import Others.User.User;
import Products.*;
import Service.Service;
import Utile.OrderStatus;
import config.DataBaseConfiguration;

import java.time.LocalDateTime;
import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        Service service=new Service();

        DataBaseConfiguration dataBaseConfiguration = new DataBaseConfiguration();


        Product product1 = new Book( "Narnia", 30);
        Product product2=new Clothing("tricou", 50);
        Product product3=new Electronics("casti", 1000);

        service.adaugaProdus(product1);
        service.adaugaProdus(product2);
        service.adaugaProdus(product3);
        Address adresa2=new Address("Strada 2", "Bucuresti", "Romania", "123456");
        Address adresa1=new Address("Strada 3", "Berlin", "Germania", "324DE");
        Review review1=new Review("bun",10);
        Review review2=new Review("foarte bun",10);
        service.adaugaRecenzielaProdus(product1,review1);
        service.adaugaRecenzielaProdus(product1,review2);
        service.adaugaRecenzielaProdus(product2,review1);
        service.adaugaRecenzielaProdus(product3,review2);
        service.stergeRecenzielaProdus(product1,review1);
        service.stergeProdus(product3);
        System.out.println(service.cautaRecenziidupaNumeleProdusului("tricou").size());
        service.adaugaAdresa(adresa1);
        service.adaugaAdresa(adresa2);
        service.stergeAdresa(adresa1);
        service.adaugaAdresa(adresa1);

        User user1=new User("Andrei", "andrei02@gmail.com", "parola",adresa1);
        User user2=new User("Daniel", "dani@yahoo.com", "parola",adresa2);
        service.adaugaUtilizator(user1);
        service.adaugaUtilizator(user2);
        service.stergeUtilizator(user1);
        Order order1=new Order(adresa2,OrderStatus.PLACED);
        order1.addProduct(product1);
        order1.addProduct(product2);
        service.adaugaComanda(order1);
        service.stergeprodus_din_comanda(order1,product1);
        service.adaugaprodus_in_comanda(order1,product3);

        service.stergeComanda(order1);
        service.adaugaAdresa(adresa2);
        service.adaugaUtilizator(user1);
        service.modifica_adresa_utilizator(user1,adresa2);
        service.adaugaComanda(order1);
        service.modifica_adresa_comanda(order1,adresa1);
        service.modifica_pretul_unui_produs(product1,100);
        service.modifica_textul_ratingul_unui_produs(product1,"foarte bun",7.0,review2);
        Review rating4=new Review("blana",13);
        service.adaugaRecenzielaProdus(product1,rating4);
        service.stergeAdresa(adresa1);
        service.stergeAdresa(adresa2);
        service.adaugaAdresa(adresa1);
        service.adaugaAdresa(adresa2);
        User user4=new User("Andrei", "dani02", "parola",adresa1);
        service.adaugaUtilizator(user4);












        }



    }

