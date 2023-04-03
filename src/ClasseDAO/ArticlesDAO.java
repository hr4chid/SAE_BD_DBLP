package ClasseDAO;

import Classes.Article;
import Initializer.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ArticlesDAO {
    private DBConnector DBconnector;
    private Connection connection;

    public ArticlesDAO() throws ClassNotFoundException {
        this.DBconnector = new DBConnector();
        this.connection = DBconnector.getConnection();
    }

    public void insertArticle(Article article) throws SQLException {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.articles (title, year, month, ee, publisher) VALUES (?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, article.getTitle());
            preparedStatement.setInt(2, article.getYear());
            preparedStatement.setString(3, article.getMonth());
            preparedStatement.setString(4, article.getEe());
            preparedStatement.setString(5, article.getPublisher());

            preparedStatement.executeUpdate();

            // Récupération de l'id de l'article inséré
            int articleId;
            try (var generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    articleId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("La récupération de l'ID de l'article a échoué.");
                }
            }
            System.out.println("Insertion réussie !" + "\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


