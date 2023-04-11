

package Service;

import Others.Order;
import Others.Review;
import Others.User;
import Products.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Service {
    private List<Product> listaProduse = new ArrayList();
    private List<User> listaUtilizatori = new ArrayList();
    private List<Order> listaComenzi = new ArrayList();
    private Map<String, List<Review>> recenziiProduse = new HashMap();

    public List<Product> getListaProduse() {
        return this.listaProduse;
    }

    public void setListaProduse(List<Product> listaProduse) {
        this.listaProduse = listaProduse;
    }

    public List<User> getListaUtilizatori() {
        return this.listaUtilizatori;
    }

    public void setListaUtilizatori(List<User> listaUtilizatori) {
        this.listaUtilizatori = listaUtilizatori;
    }

    public List<Order> getListaComenzi() {
        return this.listaComenzi;
    }

    public void setListaComenzi(List<Order> listaComenzi) {
        this.listaComenzi = listaComenzi;
    }

    public Map<String, List<Review>> getRecenziiProduse() {
        return this.recenziiProduse;
    }

    public void setRecenziiProduse(Map<String, List<Review>> recenziiProduse) {
        this.recenziiProduse = recenziiProduse;
    }

    public Service() {
    }

    public void adaugaProdus(Product produs) {
        this.listaProduse.add(produs);
    }

    public void adaugaRecenzielaProdus(Product produs, Review review) {
        ((List)this.recenziiProduse.get(produs.getName())).add(review);
    }

    public void stergeRecenzielaProdus(Product produs, Review review) {
        ((List)this.recenziiProduse.get(produs.getName())).remove(review);
    }

    public List<Review> cautaRecenziidupaProdus(Product produs) {
        return (List)this.recenziiProduse.get(produs.getName());
    }

    public void stergeProdus(Product produs) {
        this.listaProduse.remove(produs);
    }

    public Product cautaProdusDupaDenumire(String denumire) {
        for (int i = 0; i < this.listaProduse.size(); i++) {
            Product produs = this.listaProduse.get(i);
            if (produs.getName().equals(denumire)) {
                return produs;
            }
        }
        return null;
    }

    public void adaugaUtilizator(User utilizator) {
        this.listaUtilizatori.add(utilizator);
    }

    public void sortareComenzidupaId() {
        Collections.sort(this.listaComenzi, new Comparator<Order>() {
            public int compare(Order c1, Order c2) {
                return Integer.compare(c1.getId(), c2.getId());
            }
        });
    }

    public void stergeUtilizator(User utilizator) {
        this.listaUtilizatori.remove(utilizator);
    }

    public User cautaUtilizatorDupaEmail(String email) {
        for (int i = 0; i < this.listaUtilizatori.size(); i++) {
            User utilizator = this.listaUtilizatori.get(i);
            if (utilizator.getEmail().equals(email)) {
                return utilizator;
            }
        }
        return null;
    }

    public void adaugaComanda(Order comanda) {
        this.listaComenzi.add(comanda);
    }

    public void stergeComanda(Order comanda) {
        this.listaComenzi.remove(comanda);
    }

    public Order cautaComandaDupaID(int id) {
        for (int i = 0; i < this.listaComenzi.size(); i++) {
            Order comanda = this.listaComenzi.get(i);
            if (comanda.getId() == id) {
                return comanda;
            }
        }
        return null;
    }
}
