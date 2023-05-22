package Others.Order;

import Order_Product.Order_ProductRepository;
import Order_Product.Order_Product;
import Others.Address.Address;
import Others.Address.AddressRepository;
import Products.Product;
import Utile.OrderStatus;
import config.DataBaseConfiguration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private final DataBaseConfiguration connection;

    public OrderRepository(DataBaseConfiguration dataBaseConfiguration) {
        this.connection = dataBaseConfiguration;
    }


    public List<Order> getAllOrders_sorted() {
        Order_ProductRepository order_productRepository = new Order_ProductRepository(connection);
        AddressRepository addressRepository = new AddressRepository(connection);
        List<Order> orders = new ArrayList<>();
        try {
            Statement statement = connection.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM proiect.order ORDERED BY id ASC");
            while (result.next()) {
                List<Product> produse = new ArrayList<>();
                OrderStatus status = null;
                int id = result.getInt("id");
                LocalDateTime date = result.getTimestamp("date").toLocalDateTime();
                if (result.getString("status").equals("PLACED"))
                    status = OrderStatus.PLACED;
                if (result.getString("status").equals("PROCESSED"))
                    status = OrderStatus.PROCESSED;
                if (result.getString("status").equals("DELIVERED"))
                    status = OrderStatus.DELIVERED;
                if (result.getString("status").equals("SHIPPED"))
                    status = OrderStatus.SHIPPED;
                int id_address = result.getInt("id_address");
                Order order = new Order(id, date, addressRepository.get_Address(id_address), order_productRepository.getAllproducts_id_order(id), status);


            }
            statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;

    }


    public List<Order> getAllOrders() {
        Order_ProductRepository order_productRepository = new Order_ProductRepository(connection);
        AddressRepository addressRepository = new AddressRepository(connection);
        List<Order> orders = new ArrayList<>();
        try {
            Statement statement = connection.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM proiect.order");
            while (result.next()) {
                List<Product> produse = new ArrayList<>();
                OrderStatus status = null;
                int id = result.getInt("id");
                LocalDateTime date = result.getTimestamp("date").toLocalDateTime();
                if (result.getString("status").equals("PLACED"))
                    status = OrderStatus.PLACED;
                if (result.getString("status").equals("PROCESSED"))
                    status = OrderStatus.PROCESSED;
                if (result.getString("status").equals("DELIVERED"))
                    status = OrderStatus.DELIVERED;
                if (result.getString("status").equals("SHIPPED"))
                    status = OrderStatus.SHIPPED;
                int id_address = result.getInt("id_address");
                Order order = new Order(id, date, addressRepository.get_Address(id_address), order_productRepository.getAllproducts_id_order(id), status);


            }
            statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;

    }

    public void add_Order(Order order) {
        Order_ProductRepository order_productRepository = new Order_ProductRepository(connection);
        try {
            PreparedStatement selectStatement=connection.getConnection().prepareStatement("SELECT * FROM proiect.order WHERE id=?");
            selectStatement.setInt(1,order.getId());
            ResultSet resultSet=selectStatement.executeQuery();
            if(!resultSet.next()) {
                Statement statement = connection.getConnection().createStatement();
                statement.executeUpdate("INSERT INTO proiect.order VALUES(" + order.getId() + ",'" + order.getDate() + "','" + order.getStatus().toString() + "'," + order.getDeliveryAddress().getId() + ")");
                statement.close();
                for (Product product : order.getProducts()) {
                    order_productRepository.insert(new Order_Product(order.getId(), product.getId()));
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete_Order(Order order) {
        Order_ProductRepository order_productRepository = new Order_ProductRepository(connection);
        try {

            for (Product product : order.getProducts()) {
                order_productRepository.delete(new Order_Product(order.getId(), product.getId()));
            }
            Statement statement = connection.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM proiect.order WHERE id=" + order.getId());
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void update_Order(Order order) {
        Order_ProductRepository order_productRepository = new Order_ProductRepository(connection);
        try {
            order_productRepository.delete_id_order(order.getId());

            for (Product product : order.getProducts()) {
                order_productRepository.insert(new Order_Product(order.getId(), product.getId()));
            }
            Statement statement = connection.getConnection().createStatement();
            statement.executeUpdate("UPDATE proiect.order SET id=" + order.getId() + ", date='" + order.getDate() + "', status='" + order.getStatus() + "', id_address=" + order.getDeliveryAddress().getId() + " WHERE id=" + order.getId());
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void change_Address_Order(Address address)
    {
        try{
            Statement statement=connection.getConnection().createStatement();
            statement.executeUpdate("UPDATE proiect.order SET id_address= NULL "+" WHERE id_address="+address.getId());
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

}


