
package Others;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    public static void CSVWriter() {
        File file = new File("src\\CSV_Files\\Review.csv");
        if (!file.exists()) {
            try {
                FileWriter csvWriter = new FileWriter("src\\CSV_Files\\Review.csv");
                CSVWriter writer = new CSVWriter(csvWriter);
                String[] header = {"Text", "Rating", "Id_Produs"};
                writer.writeNext(header);
                csvWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
