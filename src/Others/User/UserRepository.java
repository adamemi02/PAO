package Others.User;

import Order_Product.Order_Product;
import Order_Product.Order_ProductRepository;
import Others.Address.Address;
import Others.Address.AddressRepository;
import Others.Notification.Notification;
import Others.Order.Order;
import Products.Product;
import config.DataBaseConfiguration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {


    private final DataBaseConfiguration connection;

    public UserRepository(DataBaseConfiguration dataBaseConfiguration) {
        this.connection = dataBaseConfiguration;
    }

    public User get_user_by_email(String email)
    {
        AddressRepository addressRepository=new AddressRepository(connection);
        try{Statement statement=connection.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery("select * from user where email="+ email);
            return new  User(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("email"),resultSet.getString("password"),addressRepository.get_Address(resultSet.getInt("id_address")));


        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }


    public void insert(User user) {
        try {
            PreparedStatement selectStatement = connection.getConnection().prepareStatement("SELECT * FROM user WHERE id=?");
            selectStatement.setInt(1, user.getId());
            ResultSet resultSet = selectStatement.executeQuery();
            if (!resultSet.next()) {
                PreparedStatement statement = connection.getConnection().prepareStatement("INSERT INTO user VALUES (?,?,?,?,?)");
                statement.setInt(1, user.getId());
                statement.setString(2, user.getName());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getPassword());
                statement.setInt(5, user.getPreferredAddress().getId());
                statement.executeUpdate();
                  statement.close();

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(User user) {

        try {
            Statement statement = connection.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM user WHERE id=" + user.getId());
            statement.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void update(User user) {
        try {
            Statement statement = connection.getConnection().createStatement();
            statement.executeUpdate("UPDATE user SET name='" + user.getName() + "',email='" + user.getEmail() + "',password='" + user.getPassword() + "',id_address='" + user.getPreferredAddress().getId() + "' WHERE id=" + user.getId());
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        AddressRepository addressRepository= new AddressRepository(connection);
        try {
            Statement statement = connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("password"), addressRepository.get_Address(resultSet.getInt("id_address")));
                users.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return users;
    }

    public void change_Address_User(Address address)
    {
        try{
            Statement statement=connection.getConnection().createStatement();
            statement.executeUpdate("UPDATE proiect.user SET id_address= NULL "+" WHERE id_address="+address.getId());
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}