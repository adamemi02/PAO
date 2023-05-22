package Products;

import Utile.ProductCategory;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Product {

    private int id;
    private String name;
    private double price;
    private ProductCategory category;


    public Product(int id,String name, double price, ProductCategory category) {
        this.id=id;
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

    public void setId(int id) {
        this.id = id;
    }

    public static void CSVWriter()
    {
        File file=new File("src\\CSV_Files\\Product.csv");
        if(!file.exists())
        {
            try{
                FileWriter csvWriter=new FileWriter("src\\CSV_Files\\Product.csv");
                CSVWriter writer=new CSVWriter(csvWriter);
                String[] data = {"Id", "Nume", "Pret", "Categorie"};
                writer.writeNext(data);
                csvWriter.close();

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }





}
