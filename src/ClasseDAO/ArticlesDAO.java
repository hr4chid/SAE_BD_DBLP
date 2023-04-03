package ClasseDAO;

import Classes.Article;
import Initializer.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticlesDAO {
    private DBConnector DBconnector;
    private Connection connection;

    public ArticlesDAO() throws ClassNotFoundException {
        this.DBconnector = new DBConnector();
        this.connection = DBconnector.getConnection();
    }

    public void insertArticle(Article article) throws SQLException {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.articles (author, title, year, month, ee, publisher) VALUES (?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, article.getAuthor());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setInt(3, article.getYear());
            preparedStatement.setString(4, article.getMonth());
            preparedStatement.setString(5, article.getEe());
            preparedStatement.setString(6, article.getPublisher());

            preparedStatement.executeUpdate();
            System.out.println("Insertion réussie !" + "\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


