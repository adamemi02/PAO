
package Others;

public class Review {
    private String text;
    private double rating;

    public Review(String text, double rating) {
        this.text = text;
        this.rating = rating;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
