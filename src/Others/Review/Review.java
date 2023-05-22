
package Others.Review;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Review {
    private static int nr_review=0;

    public int getId() {
        return id;
    }

    public int getId_produs() {
        return id_produs;
    }

    private int id;
    private String text;
    private double rating;

    private int id_produs;

    public Review(String text, double rating) {
        ++nr_review;
        this.id=nr_review;
        this.text = text;
        this.rating = rating;
    }

    public Review(int id,String text, double rating,int id_produs) {
        ++nr_review;
        this.id=id;
        this.text = text;
        this.rating = rating;
        this.id_produs=id_produs;
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
