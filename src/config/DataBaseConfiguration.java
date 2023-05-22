package config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfiguration {

    private final Connection dataBaseConnection;
    public DataBaseConfiguration(){

        try{
                String url="jdbc:mysql://127.0.0.1:3306/proiect";
                String username="root";
                String password="root";
                dataBaseConnection= DriverManager.getConnection(url,username,password);
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection()
    {
        return dataBaseConnection;
    }
}
