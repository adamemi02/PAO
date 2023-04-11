

import Others.Address;
import Others.Order;
import Others.Review;
import Others.User;
import Products.Book;
import Products.Clothing;
import Products.Electronics;
import Products.Product;
import Service.Service;
import Utile.OrderStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Service service = new Service();
        Product cuptor = new Electronics("cuptor", 50.5);
        Product carte = new Book("Romeo&Julieta", 5.5);
        Product pantaloni = new Clothing("pantaloni", 30.5);
        service.adaugaProdus(cuptor);
        service.adaugaProdus(carte);
        service.adaugaProdus(pantaloni);
        service.stergeProdus(carte);
        System.out.println(service.cautaProdusDupaDenumire("pantaloni").Descriere());
        Address address1 = new Address("Venus", "Bacau", "Romania", "600372");
        Address address2 = new Address("Prieteniei", "Timis", "Romania", "600202");
        User user1 = new User("Emanuel", "adamemi02@gmail.com", "1234", address1);
        User user2 = new User("Alex", "alex89@gmail.com", "abcd", address2);
        service.adaugaUtilizator(user1);
        service.adaugaUtilizator(user2);
        service.stergeUtilizator(user1);
        System.out.println(service.cautaUtilizatorDupaEmail("alex89@gmail.com").toString());
        Order comanda1 = new Order(1234, new ArrayList(), address1, OrderStatus.DELIVERED);
        Order comanda2 = new Order(2345, new ArrayList(), address2, OrderStatus.PLACED);
        Order comanda3 = new Order(1000, new ArrayList(), address2, OrderStatus.PLACED);
        Order comanda4 = new Order(4500, new ArrayList(), address2, OrderStatus.PLACED);
        service.adaugaComanda(comanda1);
        service.adaugaComanda(comanda2);
        service.stergeComanda(comanda2);
        service.adaugaComanda(comanda3);
        service.adaugaComanda(comanda4);
        System.out.println(service.cautaComandaDupaID(1234).getStatus());
        service.sortareComenzidupaId();

        for(int i = 0; i < service.getListaComenzi().size(); ++i) {
            System.out.println(((Order)service.getListaComenzi().get(i)).getId());
        }

        Review review1 = new Review("Perfect", 10.0);
        Review review2 = new Review("Decent", 7.5);
        Review review3 = new Review("Deplorabil", 3.0);
        Review review4 = new Review("Superb", 9.5);
        Map<String, List<Review>> aux = new HashMap();
        aux.put(pantaloni.getName(), new ArrayList());
        aux.put(carte.getName(), new ArrayList());
        service.setRecenziiProduse(aux);
        service.adaugaRecenzielaProdus(pantaloni, review1);
        service.adaugaRecenzielaProdus(pantaloni, review2);
        service.adaugaRecenzielaProdus(carte, review1);
        service.adaugaRecenzielaProdus(carte, review2);
        service.adaugaRecenzielaProdus(carte, review3);
        service.adaugaRecenzielaProdus(carte, review4);
        service.stergeRecenzielaProdus(pantaloni, review1);
        service.stergeRecenzielaProdus(carte, review2);

        for(int i = 0; i < service.cautaRecenziidupaProdus(carte).size(); ++i) {
            System.out.println(((Review)service.cautaRecenziidupaProdus(carte).get(i)).getText());
        }

    }
}
