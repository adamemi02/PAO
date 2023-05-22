package Products;

import Order_Product.Order_ProductRepository;
import Others.Review.ReviewRepository;
import config.DataBaseConfiguration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private final DataBaseConfiguration connection;

    public ProductRepository(DataBaseConfiguration connection) {
        this.connection = connection;
    }

    public void insert(Product product) {
        try {
            PreparedStatement selectStatement=connection.getConnection().prepareStatement("SELECT * FROM product WHERE id=?");
            selectStatement.setInt(1,product.getId());
            ResultSet resultSet=selectStatement.executeQuery();
            if(!resultSet.next())
            {String query = "INSERT INTO product VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.getConnection().prepareStatement(query);
            statement.setInt(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getCategory().toString());
            statement.executeUpdate();
            statement.close();}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Product product) {
        Order_ProductRepository orderProductRepository=new Order_ProductRepository(connection);
        ReviewRepository reviewRepository = new ReviewRepository(connection);

        try {
            reviewRepository.delete_reviews_of_a_product(product);
            orderProductRepository.delete_id_product(product.getId());
            Statement statement = connection.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM product WHERE id=" + product.getId());
            statement.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Product product) {
        try {
            Statement statement = connection.getConnection().createStatement();
            String query = "UPDATE product SET name='" + product.getName() + "', price=" + product.getPrice() + ", category='" + product.getCategory().toString() + "' WHERE id=" + product.getId();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




    public List<Product> getAllproducts() {
        List<Product> products = new ArrayList<>();
        try {
            Statement statement = connection.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM product");
            while (result.next()) {


                if (result.getString("category").equals("ELECTRONICS")) {
                    Product product = new Electronics(result.getInt("id"), result.getString("name"), result.getDouble("price"));
                    products.add(product);
                } else if (result.getString("category").equals("CLOTHING")) {
                    Product product = new Clothing(result.getInt("id"), result.getString("name"), result.getDouble("price"));
                    products.add(product);
                } else if (result.getString("category").equals("BOOK")) {
                    Product product = new Book(result.getInt("id"), result.getString("name"), result.getDouble("price"));
                    products.add(product);
                }
            }

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;

    }

    public Product getProduct_by_name(String name)
    {
        Product product=null;
        try{
            PreparedStatement statement=connection.getConnection().prepareStatement("SELECT * FROM product WHERE name=?");
            statement.setString(1,name);
            ResultSet result=statement.executeQuery();
            while(result.next())
            {
                if(result.getString("category").equals("ELECTRONICS"))
                {
                    product=new Electronics(result.getInt("id"),result.getString("name"),result.getDouble("price"));
                }
                else if(result.getString("category").equals("CLOTHING"))
                {
                    product=new Clothing(result.getInt("id"),result.getString("name"),result.getDouble("price"));
                }
                else if(result.getString("category").equals("BOOK"))
                {
                    product=new Book(result.getInt("id"),result.getString("name"),result.getDouble("price"));
                }
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public Product getProduct(int id)
    {
        Product product=null;
        try{
            Statement statement=connection.getConnection().createStatement();
            ResultSet result=statement.executeQuery("SELECT * FROM product WHERE id="+id);
            while(result.next())
            {
                if(result.getString("category").equals("ELECTRONICS"))
                {
                    product=new Electronics(result.getInt("id"),result.getString("name"),result.getDouble("price"));
                }
                else if(result.getString("category").equals("CLOTHING"))
                {
                    product=new Clothing(result.getInt("id"),result.getString("name"),result.getDouble("price"));
                }
                else if(result.getString("category").equals("BOOK"))
                {
                    product=new Book(result.getInt("id"),result.getString("name"),result.getDouble("price"));
                }
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}

