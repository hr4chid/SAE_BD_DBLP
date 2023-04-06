package ClasseDAO;

import Classes.Article;
import Initializer.DBConnector;

import java.sql.Array;
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
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.articles (author, title, pages, year, volume, journal, number, ee, url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setArray(1, article.getAuthor());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setInt(3, article.getPage());
            preparedStatement.setInt(4, article.getYear());
            preparedStatement.setInt(5, article.getVolume());
            preparedStatement.setString(6, article.getJournal());
            preparedStatement.setInt(7, article.getNumber());
            preparedStatement.setArray(8, (Array) article.getEe());
            preparedStatement.setString(9, article.getUrl());


            preparedStatement.executeUpdate();
            System.out.println("Insertion des données réussie !" + "\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


