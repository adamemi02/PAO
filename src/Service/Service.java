

package Service;

import Others.Address;
import Others.Order;
import Others.Review;
import Others.User;
import Products.Product;
import Read_Write.Read_Write;
import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Service {



    public static int nr_actiuni=0;
    Read_Write readWrite= Read_Write.getInstance();
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
        listaProduse.add(produs);
        readWrite.write_product_to_File(produs);
        nr_actiuni++;
        Service.TimeStamp("Adaugare_produs");
    }

    public List<Product> getProducts()
    {
        return readWrite.read_products_from_File();
    }

    public void adaugaRecenzielaProdus(Product produs, Review review) {
        if (!this.recenziiProduse.containsKey(produs.getName())) {
            this.recenziiProduse.put(produs.getName(), new ArrayList());
        }
        ((List)this.recenziiProduse.get(produs.getName())).add(review);
        nr_actiuni++;
        readWrite.write_review_to_File(review,produs);
        Service.TimeStamp("Adaugare_recenzie");
    }

    public void stergeRecenzielaProdus(Product produs, Review review) {
        readWrite.delete_review_from_File(review,produs);
        ((List)this.recenziiProduse.get(produs.getName())).remove(review);

    }

    public List<Review> cautaRecenziidupaNumeleProdusului(String nume) {
        nr_actiuni++;
        Service.TimeStamp("Cautare_recenzie");
        return (List)this.recenziiProduse.get(nume);
    }

    public void stergeProdus(Product produs) {
        nr_actiuni++;
        this.listaProduse.remove(produs);
        readWrite.delete_product_from_File(produs);
        Service.TimeStamp("Stergere_produs");
    }

    public Product cautaProdusDupaDenumire(String denumire) {
        nr_actiuni++;
        Service.TimeStamp("Cautare_produs");
        return readWrite.search_product_by_name(denumire);
    }

    public void adaugaUtilizator(User utilizator) {
        nr_actiuni++;
        this.listaUtilizatori.add(utilizator);
        readWrite.write_user_to_File(utilizator);
        Service.TimeStamp("Adaugar_utilizator");
    }

    public void adaugaAdresa(Address address)
    {
        readWrite.write_address_to_File(address);
        Service.TimeStamp("Adaugare_adresa");

    }

    public void sortareComenzidupaId() {
        nr_actiuni++;
        Collections.sort(this.listaComenzi, new Comparator<Order>() {
            public int compare(Order c1, Order c2) {
                return Integer.compare(c1.getId(), c2.getId());
            }
        });
        Service.TimeStamp("Sortare_comenzi");
    }

    public void stergeUtilizator(User utilizator)
    {nr_actiuni++;
        this.listaUtilizatori.remove(utilizator);
        readWrite.delete_user_from_file(utilizator);
        Service.TimeStamp("Stergere_utilizator");
    }



    public User cautaUtilizatorDupaEmail(String email) {
        nr_actiuni++;
        for (int i = 0; i < this.listaUtilizatori.size(); i++) {
            User utilizator = this.listaUtilizatori.get(i);
            if (utilizator.getEmail().equals(email)) {
                return utilizator;
            }
        }
        Service.TimeStamp("Cautare_utilizator");
        return null;
    }

    public void adaugaComanda(Order comanda)
    {nr_actiuni++;
        readWrite.write_order_to_File(comanda);
        this.listaComenzi.add(comanda);
        Service.TimeStamp("Adaugare_comanda");
    }

    public void stergeComanda(Order comanda) {nr_actiuni++;

        this.listaComenzi.remove(comanda);
        readWrite.delete_order_from_file(comanda);
        Service.TimeStamp("Stergere_comanda");
    }

    public Order cautaComandaDupaID(int id) {
        nr_actiuni++;
        for (int i = 0; i < this.listaComenzi.size(); i++) {
            Order comanda = this.listaComenzi.get(i);
            if (comanda.getId() == id) {
                return comanda;
            }

        }
        Service.TimeStamp("Cautare_comanda");
        return null;

    }

    public static void TimeStamp( String nume_actiune)
    {
        Timestamp time7=new Timestamp(System.currentTimeMillis());
        try{
            FileWriter file=new FileWriter("src\\CSV_Files\\TimeStamp.csv",true);
            CSVWriter writer=new CSVWriter(file);
            String[] header={nume_actiune,time7.toString()};
            writer.writeNext(header);
            writer.close();}
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
