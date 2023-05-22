

package Others.Address;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
public class Address {

    private static int nr_adrese=0;

    private int id;
    private String street;

    public int getId() {
        return id;
    }

    private String city;
    private String state;
    private String zipCode;

    public Address(int id,String street, String city, String state, String zipCode) {
        ++nr_adrese;
        this.id=id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Address(String street, String city, String state, String zipCode) {
        ++nr_adrese;
        this.id=nr_adrese;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }









}
