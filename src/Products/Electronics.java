package Products;

import Utile.ProductCategory;

public class Electronics extends Product {
    public Electronics(String name, double price) {
        super(name, price,ProductCategory.ELECTRONICS);
    }

    @Override
    public String Descriere() {
        return "Electronics:"+name+ "__Price:"+price;
    }
}
