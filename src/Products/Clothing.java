package Products;

import Utile.ProductCategory;

public class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price,ProductCategory.CLOTHING);
    }

    public Clothing(int id,String name, double price) {
        super(id,name, price,ProductCategory.CLOTHING);
    }

    @Override
    public String Descriere() {
        return "Clothing:"+getName()+ "__Price:"+getPrice();
    }
}
