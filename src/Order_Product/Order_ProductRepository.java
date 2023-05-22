package Order_Product;

import Products.Product;
import Products.ProductRepository;
import config.DataBaseConfiguration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Order_ProductRepository {

    private final DataBaseConfiguration connection;

    public Order_ProductRepository(DataBaseConfiguration connection) {
        this.connection = connection;
    }

    public void insert(Order_Product order_product){
        try {
            Statement statement = connection.getConnection().createStatement();
            statement.executeUpdate("INSERT INTO order_product VALUES (" + order_product.getId_product() + ", " + order_product.getId_order() + ")");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Order_Product order_product){
        try {
            Statement statement = connection.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM order_product WHERE id_product=" + order_product.getId_product() + " AND id_order=" + order_product.getId_order());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete_id_order(int id_order){
        try {
            Statement statement = connection.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM order_product WHERE id_order=" + id_order);
            statement.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete_id_product(int id_product){
        try {
            Statement statement = connection.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM order_product WHERE id_product=" + id_product);
            statement.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAllproducts_id_order(int id_order)
    {
        ProductRepository productRepository = new ProductRepository(connection);
        List<Product> products=new ArrayList<>();
        try{
            Statement statement=connection.getConnection().createStatement();
            ResultSet result=statement.executeQuery("SELECT * FROM order_product WHERE id_order=" + id_order);
            while(result.next())
            {
                products.add(productRepository.getProduct(result.getInt("id_product")));
            }
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        return products;

    }
}
