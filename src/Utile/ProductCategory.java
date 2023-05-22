
package Utile;

public enum ProductCategory {
    ELECTRONICS,
    CLOTHING,
    BOOKS;

    @Override
    public String toString() {
        switch (this) {
            case ELECTRONICS:
                return "ELECTRONICS";
            case CLOTHING:
                return "CLOTHING";
            case BOOKS:
                return "BOOKS";
            default:
                return "Unknown";
        }
    }
}
