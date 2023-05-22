package Products;

import Utile.ProductCategory;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Product {

    private static int nr_produse=0;

    private int id;
    private String name;
    private double price;
    private ProductCategory category;

    public Product(int id,String name, double price, ProductCategory category) {

        ++nr_produse;
        this.id=id;
        this.name = name;
        this.price = price;
        this.category = category;
    }


    public Product(String name, double price, ProductCategory category) {
        ++nr_produse;
        this.id=nr_produse;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    public abstract String Descriere();

    public int getId() {
        return id;
    }








}
