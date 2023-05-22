package Utile;

public enum OrderStatus {
    PLACED,
    PROCESSED,
    SHIPPED,
    DELIVERED;

    @Override

    public String toString()
    {
        switch(this)
        {
            case PLACED:
                return "PLACED";
            case PROCESSED:
                return "PROCESSED";
            case SHIPPED:
                return "SHIPPED";
            case DELIVERED:
                return "DELIVERED";
            default:
                return "Unknown";
        }


    }
}
