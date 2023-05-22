

package Others;

import Products.Product;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String email;
    private String password;
    private Address preferredAddress;
    private List<Product> favoriteProducts;
    private ShoppingCart shoppingCart;
    private List<Order> orderHistory;
    private List<Notification> notifications;

    public String toString() {
        String var10000 = this.name;
        return "User{name='" + var10000 + "', email='" + this.email + "', password='" + this.password + "', preferredAddress=" + String.valueOf(this.preferredAddress) + ", favoriteProducts=" + String.valueOf(this.favoriteProducts) + ", shoppingCart=" + String.valueOf(this.shoppingCart) + ", orderHistory=" + String.valueOf(this.orderHistory) + ", notifications=" + String.valueOf(this.notifications) + "}";
    }

    public User(String name, String email, String password, Address preferredAddress) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferredAddress = preferredAddress;
        this.favoriteProducts = new ArrayList();
        this.shoppingCart = new ShoppingCart();
        this.orderHistory = new ArrayList();
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

    public List<Product> getFavoriteProducts() {
        return this.favoriteProducts;
    }

    public void setFavoriteProducts(List<Product> favoriteProducts) {
        this.favoriteProducts = favoriteProducts;
    }

    public ShoppingCart getShoppingCart() {
        return this.shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public List<Order> getOrderHistory() {
        return this.orderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public List<Notification> getNotifications() {
        return this.notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }
}
