package Products;

import Utile.ProductCategory;

public class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price,ProductCategory.CLOTHING);
    }

    @Override
    public String Descriere() {
        return "Clothing:"+name+ "__Price:"+price;
    }
}
