package Products;

import Utile.ProductCategory;

public class Electronics extends Product {
    public Electronics(String name, double price) {
        super(name, price,ProductCategory.ELECTRONICS);
    }

    public Electronics(int id,String name, double price) {
        super(id,name, price,ProductCategory.ELECTRONICS);
    }

    @Override
    public String Descriere() {
        return "Electronics:"+getName()+ "__Price:"+getPrice();
    }


}
