

package Others.User;

import Others.Address.Address;
import Others.Notification.Notification;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static int nr_useri=0;

    public int getId() {
        return id;
    }

    private int id;
    private String name;
    private String email;
    private String password;
    private Address preferredAddress;
    private List<Notification> notifications;

    public String toString() {
        String var10000 = this.name;
        return "User{name='" + var10000 + "', email='" + this.email + "', password='" + this.password + "', preferredAddress=" +  ", notifications=" + String.valueOf(this.notifications) + "}";
    }

    public User(String name, String email, String password, Address preferredAddress) {
        ++nr_useri;
        this.id=nr_useri;
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferredAddress = preferredAddress;
        this.notifications = new ArrayList();
    }

    public User(int id,String name, String email, String password, Address preferredAddress) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferredAddress = preferredAddress;
        this.notifications = new ArrayList();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getPreferredAddress() {
        return this.preferredAddress;
    }

    public void setPreferredAddress(Address preferredAddress) {
        this.preferredAddress = preferredAddress;
    }


    public List<Notification> getNotifications() {
        return this.notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public void addNotification(Notification notification)
    {

        this.notifications.add(new Notification(notification.getId(),notification.getText(),notification.getDateTime(),this.id));
    }


    }

