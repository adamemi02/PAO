

package Others.Order;

import Others.Address.Address;
import Products.Product;
import Utile.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Order {
    private static int idCounter=0;
    private int id;
    private LocalDateTime date;
    private List<Product> products;
    private Address deliveryAddress;
    private OrderStatus status;

    public Order( Address deliveryAddress, OrderStatus status) {
        idCounter++;
        this.id = idCounter;
        this.date = LocalDateTime.now();
        this.products =new ArrayList<>();
        this.status = status;
        this.deliveryAddress = deliveryAddress;
    }

    public Order(int id,LocalDateTime date,Address deliveryAddress,List<Product> products,OrderStatus status)
    {
        this.id=id;
        this.date=date;
        this.products=products;
        this.status=status;
        this.deliveryAddress=deliveryAddress;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            public int  compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });
        this.products = products;
    }

    public Address getDeliveryAddress() {
        return this.deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
    public void deleteProduct(Product product) {
        this.products.remove(product);
    }



}
