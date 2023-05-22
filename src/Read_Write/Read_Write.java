package Read_Write;

import Others.Address;
import Others.Order;
import Others.Review;
import Others.User;
import Products.Book;
import Products.Clothing;
import Products.Electronics;
import Products.Product;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Read_Write{
    private static Read_Write instance = null;

    private Read_Write() {
        // Constructor privat pentru a preveni crearea instanțelor din afara clasei
    }

    public static Read_Write getInstance() {
        if (instance == null) {
            instance = new Read_Write();
        }
        return instance;
    }

    public void write_order_to_File(Order order)
    {

        ArrayList lista=new ArrayList<>();
                for (Product produs:order.getProducts())
                    lista.add(produs.getName());
                String produse=String.join(",",lista);
        try {
            FileWriter fileWriter=new FileWriter("src\\CSV_Files\\Order.csv",true);
            CSVWriter writer=new CSVWriter(fileWriter);
            String [] header={Integer.toString(order.getId()),order.getDate().toString(),produse,order.getDeliveryAddress().getZipCode(),order.getStatus().toString()};
            writer.writeNext(header);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write_review_to_File(Review review,Product product)
    {


        try {
            FileWriter fileWriter=new FileWriter("src\\CSV_Files\\Review.csv",true);
            CSVWriter writer=new CSVWriter(fileWriter);
            String [] header={review.getText(),Double.toString(review.getRating()),Integer.toString(product.getId())};
            writer.writeNext(header);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  List<Product> read_products_from_File()
    {
        ArrayList produse=new ArrayList<>();
        String file="src\\CSV_Files\\Product.csv";

        String csvDelimiter=",";
        try{
            BufferedReader reader=new BufferedReader(new FileReader(file));
            String line;
            line=reader.readLine();
            while((line=reader.readLine())!=null)
            {
                String[] fields=line.split(csvDelimiter);
                if(fields[3].replace("\"","").equals("Book")) {
                    Product produs = new Book(Integer.parseInt(fields[0].replace("\"", "")), fields[1].replace("\"", ""), Double.parseDouble(fields[2].replace("\"", "")));
                    produse.add(produs);
                }
                else{
                    if(fields[3].replace("\"","").equals("Clothing"))
                    {
                        Product produs=new Clothing(Integer.parseInt(fields[0].replace("\"","")),fields[1].replace("\"",""),Double.parseDouble(fields[2].replace("\"","")));
                        produse.add(produs);
                    }
                    else
                    {
                        Product produs=new Electronics(Integer.parseInt(fields[0].replace("\"","")),fields[1].replace("\"",""),Double.parseDouble(fields[2].replace("\"","")));
                        produse.add(produs);
                    }
                }


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return produse;

    }



    public static   List<Review> read_reviews_from_file()
    {
        ArrayList reviews=new ArrayList<>();
        String file="src\\CSV_Files\\Review.csv";

        String csvDelimiter=",";
        try{
            BufferedReader reader=new BufferedReader(new FileReader(file));
            String line;
            line=reader.readLine();
            while((line=reader.readLine())!=null)
            {
                String[] fields=line.split(csvDelimiter);

                    Review review = new Review(fields[0].replace("\"", ""), Double.parseDouble(fields[1].replace("\"", "")));
                    reviews.add(review);



            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return reviews;

    }





    public void write_product_to_File( Product produs)
    {
        try {
            FileWriter fileWriter=new FileWriter("src\\CSV_Files\\Product.csv",true);
            CSVWriter writer=new CSVWriter(fileWriter);
            String [] header={Integer.toString(produs.getId()),produs.getName(),Double.toString(produs.getPrice()),produs.getCategory().toString()};
            writer.writeNext(header);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write_user_to_File(User user)
    {
        try {
            FileWriter fileWriter=new FileWriter("src\\CSV_Files\\User.csv",true);
            CSVWriter writer=new CSVWriter(fileWriter);
            String [] header={user.getName(),user.getEmail(),user.getPassword(),user.getPreferredAddress().getZipCode()};
            writer.writeNext(header);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write_address_to_File(Address adresa)
    {
        try {
            FileWriter fileWriter=new FileWriter("src\\CSV_Files\\Address.csv",true);
            CSVWriter writer=new CSVWriter(fileWriter);
            String [] header={adresa.getStreet(),adresa.getCity(),adresa.getState(),adresa.getZipCode()};
            writer.writeNext(header);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String readFromFile(String fileName) {
        String content = "";
        try {
            FileReader fileReader = new FileReader(fileName);
            int character;
            while ((character = fileReader.read()) != -1) {
                content += (char) character;
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public void delete_review_from_File(Review review, Product produs) {
        String file = "src\\CSV_Files\\Review.csv";
        String csvDelimiter = ",";
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<String[]> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(csvDelimiter);
                if (fields[0].replace("\"", "").equals(review.getText()) && fields[1].replace("\"", "").equals(Double.toString(review.getRating())) && fields[2].replace("\"", "").equals(Integer.toString(produs.getId()))) {
                    continue;
                }
                lines.add(fields);
            }
            reader.close();
            FileWriter writer = new FileWriter(file);
            for (String[] fields : lines) {
                writer.write(String.join(csvDelimiter, fields) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete_user_from_file(User user)
    {
        String file = "src\\CSV_Files\\User.csv";
        String csvDelimiter = ",";
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<String[]> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(csvDelimiter);
                if (fields[0].replace("\"", "").equals(user.getName()) && fields[1].replace("\"", "").equals(user.getEmail()) && fields[2].replace("\"", "").equals(user.getPassword()) && fields[3].replace("\"", "").equals(user.getPreferredAddress().getZipCode())) {
                    continue;
                }
                lines.add(fields);
            }
            reader.close();
            FileWriter writer = new FileWriter(file);
            for (String[] fields : lines) {
                writer.write(String.join(csvDelimiter, fields) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete_order_from_file(Order order)
    {
        String file = "src\\CSV_Files\\Order.csv";
        String csvDelimiter = ",";
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<String[]> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(csvDelimiter);
                if (fields[0].replace("\"", "").equals(Integer.toString(order.getId()))) {
                    continue;
                }
                lines.add(fields);
            }
            reader.close();
            FileWriter writer = new FileWriter(file);
            for (String[] fields : lines) {
                writer.write(String.join(csvDelimiter, fields) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete_product_from_File(Product produs) {
        String file = "src\\CSV_Files\\Product.csv";
        String csvDelimiter = ",";
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            List<String[]> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(csvDelimiter);
                if (fields[0].replace("\"", "").equals(Integer.toString(produs.getId())) && fields[1].replace("\"", "").equals(produs.getName()) && fields[2].replace("\"", "").equals(Double.toString(produs.getPrice())) && fields[3].replace("\"", "").equals(produs.getCategory().toString())) {
                    continue;
                }
                lines.add(fields);
            }
            reader.close();
            FileWriter writer = new FileWriter(file);
            for (String[] fields : lines) {
                writer.write(String.join(csvDelimiter, fields) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String file2="src\\CSV_Files\\Review.csv";
        String line2;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file2));
            List<String[]> lines = new ArrayList<>();
            while ((line2 = reader.readLine()) != null) {
                String[] fields = line2.split(csvDelimiter);
                if (fields[2].replace("\"", "").equals(Integer.toString(produs.getId()))) {
                    continue;
                }
                lines.add(fields);
            }
            reader.close();
            FileWriter writer = new FileWriter(file2);
            for (String[] fields : lines) {
                writer.write(String.join(csvDelimiter, fields) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String line3;
        String file3="src\\CSV_Files\\Order.csv";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file3));
            List<String[]> lines = new ArrayList<>();
            while ((line3 = reader.readLine()) != null) {
                String[] fields = line3.split(csvDelimiter);
                fields[2]=fields[2].replace("\"", "");
                String[] produse = fields[2].split(",");

                List<String> produseList = new ArrayList<>(Arrays.asList(produse));

                // Remove the specific string from the produse array
                produseList.remove(produs.getName());

                // Convert the List back to an array
                produse = produseList.toArray(new String[0]);

                // Update fields[2] with the modified produse array
                fields[2] = String.join(",", produse);
                fields[2]="\""+fields[2];



                // Add the modified fields to the lines list
                lines.add(fields);
            }
            reader.close();
            FileWriter writer = new FileWriter(file3);
            for (String[] fields : lines) {
                writer.write(String.join(csvDelimiter, fields) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public Product search_product_by_name(String name)
    {
        String file = "src\\CSV_Files\\Product.csv";
        String csvDelimiter = ",";
        String line;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(csvDelimiter);
                if (fields[1].replace("\"", "").equals((name))) {
                    int id=Integer.parseInt(fields[0].replace("\"", ""));
                    String nume=fields[1].replace("\"", "");
                    Double price=Double.parseDouble(fields[2].replace("\"", ""));
                    if(fields[3].replace("\"","").equals("BOOK"))
                        return new Book(id,nume,price);
                    if(fields[3].replace("\"","").equals("CLOTHING"))
                        return new Clothing(id,nume,price);
                    if(fields[3].replace("\"","").equals("ELECTRONICS"))
                        return new Electronics(id,nume,price);
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
return null;
}
}
