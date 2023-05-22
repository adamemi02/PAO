package Others.Address;

import Others.Order.Order;
import Others.Order.OrderRepository;
import Others.User.UserRepository;
import config.DataBaseConfiguration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressRepository {






    private final DataBaseConfiguration connection;
    public AddressRepository(DataBaseConfiguration dataBaseConfiguration)
    {
        this.connection=dataBaseConfiguration;
    }


    public List<Address> getAllAddresses()
    {
        List<Address> adrese=new ArrayList<>();
        try{
            Statement statement=connection.getConnection().createStatement();
            ResultSet result=statement.executeQuery("SELECT * FROM address");
            while(result.next())
            {
                Address adresa=new Address(result.getInt("id"),result.getString("street"),result.getString("city"),result.getString("state"),result.getString("zipCode"));
                 adrese.add(adresa);
            }
            statement.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adrese;

    }

    public Address get_Address(int id)
    {
        try{
            Statement statement=connection.getConnection().createStatement();
            ResultSet result=statement.executeQuery("SELECT * FROM address WHERE id="+id);
             Address adresa=new Address(result.getInt("id"),result.getString("street"),result.getString("city"),result.getString("state"),result.getString("zipCode"));
             return adresa;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void delete(Address adresa)
    {

        OrderRepository orderRepository=new OrderRepository(connection);
        UserRepository userRepository=new UserRepository(connection);
        try{
            orderRepository.change_Address_Order(adresa);
            userRepository.change_Address_User(adresa);
            Statement statement=connection.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM address WHERE id="+adresa.getId());
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(Address address)
    {
        try{PreparedStatement selectStatement=connection.getConnection().prepareStatement("SELECT * FROM address WHERE id=?");
        selectStatement.setInt(1,address.getId());
        ResultSet resultSet=selectStatement.executeQuery();
        if(!resultSet.next())



        {Statement statement = connection.getConnection().createStatement();
                statement.executeUpdate("INSERT INTO address VALUES(" + address.getId() + ",'" + address.getStreet() + "','" + address.getCity() + "','" + address.getState() + "','" + address.getZipCode() + "')");
                statement.close();}
        }
             catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


    public void update(Address address)
    {
        try{
            Statement statement=connection.getConnection().createStatement();
            statement.executeUpdate("UPDATE address SET street='"+address.getStreet()+"',city='"+address.getCity()+"',state='"+address.getState()+"',zipCode='"+address.getZipCode()+"' WHERE id="+address.getId());
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Address getAddress(Address address)
    {

        try{
            Statement statement=connection.getConnection().createStatement();
            ResultSet result=statement.executeQuery("SELECT * FROM address WHERE id="+address.getId());
            Address adresa=new Address(result.getInt("id"),result.getString("street"),result.getString("city"),result.getString("state"),result.getString("zipCode"));
            statement.close();
            return adresa;
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

}
