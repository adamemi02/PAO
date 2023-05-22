

package Service;

import Order_Product.Order_ProductRepository;
import Others.Address.Address;
import Others.Address.AddressRepository;
import Others.Order.Order;
import Others.Order.OrderRepository;
import Others.Review.Review;
import Others.Review.ReviewRepository;
import Others.User.User;
import Others.User.UserRepository;
import Products.Product;
import Products.ProductRepository;
import config.DataBaseConfiguration;

import java.util.List;

public class Service {
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private ReviewRepository reviewRepository;
    private OrderRepository orderRepository;
    private AddressRepository addressRepository;
    private Order_ProductRepository order_productRepository;


    public  Service() {
        DataBaseConfiguration dataBaseConfiguration = new DataBaseConfiguration();
        this.productRepository = new ProductRepository(dataBaseConfiguration);
        this.userRepository = new UserRepository(dataBaseConfiguration);
        this.reviewRepository = new ReviewRepository(dataBaseConfiguration);
        this.orderRepository = new OrderRepository(dataBaseConfiguration);
        this.addressRepository = new AddressRepository(dataBaseConfiguration);
        this.order_productRepository = new Order_ProductRepository(dataBaseConfiguration);
    }









    public List<Product> getListaProduse() {
        return productRepository.getAllproducts();
    }


    public void adaugaProdus(Product produs) {
        productRepository.insert(produs);
    }

    public List<Product> getProducts()
    {
        return productRepository.getAllproducts();
    }

    public void adaugaRecenzielaProdus(Product produs, Review review) {
        reviewRepository.insert(review,produs);
    }

    public void stergeRecenzielaProdus(Product produs, Review review) {
        reviewRepository.delete(review,produs);

    }

    public List<Review> cautaRecenziidupaNumeleProdusului(String nume) {
        return reviewRepository.getreviews_by_product(productRepository.getProduct_by_name(nume));
    }

    public void stergeProdus(Product produs) {
        productRepository.delete(produs);

    }

    public Product cautaProdusDupaDenumire(String denumire) {
        return productRepository.getProduct_by_name(denumire);
    }

    public void stergeAdresa(Address address)
    {
        addressRepository.delete(address);
    }

    public void adaugaUtilizator(User utilizator) {
        userRepository.insert(utilizator);

    }

    public void adaugaAdresa(Address address)
    {

        addressRepository.insert(address);

    }

    public List<Order> sortareComenzidupaId() {
        return orderRepository.getAllOrders_sorted();
    }

    public void stergeUtilizator(User utilizator)
    {userRepository.delete(utilizator);}


    public void modifica_adresa_utilizator(User utilizator,Address address)
    {
        utilizator.setPreferredAddress(address);
        userRepository.update(utilizator);
    }

    public void modifica_adresa_comanda(Order comanda,Address address)
    {
        comanda.setDeliveryAddress(address);
        orderRepository.update_Order(comanda);
    }

    public void modifica_pretul_unui_produs(Product produs,double pret)
    {
        produs.setPrice(pret);
        productRepository.update(produs);
    }

    public void modifica_textul_ratingul_unui_produs(Product produs,String text,Double price,Review review)
    {
        review.setText(text);
        review.setRating(price);
        reviewRepository.update(review,produs);
    }



    public User cautaUtilizatorDupaEmail(String email) {
        return  userRepository.get_user_by_email(email);
    }

    public void adaugaComanda(Order comanda)
    {orderRepository.add_Order(comanda);
    }

    public void adaugaprodus_in_comanda(Order order,Product product)
    {
        order.addProduct(product);
        orderRepository.update_Order(order);
    }

    public void stergeprodus_din_comanda(Order order,Product product)
    {
        order.deleteProduct(product);
        orderRepository.update_Order(order);
    }

    public void stergeComanda(Order comanda) {

        orderRepository.delete_Order(comanda);
    }






    }



