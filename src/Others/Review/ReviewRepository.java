package Others.Review;

import Products.Product;
import config.DataBaseConfiguration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReviewRepository {
    private final DataBaseConfiguration connection;
    public ReviewRepository(DataBaseConfiguration dataBaseConfiguration)
    {
        this.connection=dataBaseConfiguration;
    }


    public void insert(Review review, Product product)
    {
        try {
            PreparedStatement selectStatement=connection.getConnection().prepareStatement("SELECT * FROM review WHERE id=? AND id_product=?");
            selectStatement.setInt(1,review.getId());
            selectStatement.setInt(2,product.getId());
            ResultSet resultSet=selectStatement.executeQuery();
            if(!resultSet.next())
            {String query = "INSERT INTO review VALUES (?, ?, ?, ?)";
                PreparedStatement statement = connection.getConnection().prepareStatement(query);
                statement.setInt(1, review.getId());
                statement.setString(2, review.getText());
                statement.setDouble(3, review.getRating());
                statement.setInt(4, product.getId());
                statement.executeUpdate();
                statement.close();
        }}
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(Review review,Product product)
    {
        try {

            Statement statement = connection.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM review WHERE id=" + review.getId() + " AND id_product=" + product.getId());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete_reviews_of_a_product(Product product)
    {
        try{
            Statement statement = connection.getConnection().createStatement();
            statement.executeUpdate("DELETE FROM review WHERE id_product=" + product.getId());
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Review review, Product product) {
        try {
            Statement statement = connection.getConnection().createStatement();
            String query = "UPDATE review SET text='" + review.getText() + "', rating=" + review.getRating() + " WHERE id=" + review.getId() + " AND id_product=" + product.getId();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Review> getreviews_by_product(Product product)
    {
        List<Review> reviews=new ArrayList<>();
        try{
            Statement statement= connection.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM review where id_product="+product.getId());
            while(resultSet.next())
            {
                Review review1=new Review(resultSet.getInt("id"),resultSet.getString("text"),resultSet.getInt("rating"),resultSet.getInt("id_product"));
                reviews.add(review1);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }

    public List<Review> getAll_reviews()
    {
        List<Review> reviews=new ArrayList<>();
        try {
            Statement statement = connection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM review");
            while (resultSet.next()) {
                Review review = new Review(resultSet.getInt("id"), resultSet.getString("text"), resultSet.getInt("rating"),resultSet.getInt("id_product"));
                reviews.add(review);
            }
            return reviews;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
