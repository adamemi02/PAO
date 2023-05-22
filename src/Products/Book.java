package Products;

import Utile.ProductCategory;

public class Book extends Product {
    public Book(String name, double price) {
        super(name, price,ProductCategory.BOOKS);
    }

    public Book(int id,String name, double price) {
        super(id,name, price,ProductCategory.BOOKS);
    }

    @Override
    public String Descriere() {
        return "Book:"+getName()+ "__Price:"+getPrice();
    }
}
