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
            PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO dblp.articles (author, title, year, volume, journal, number, ee, url, startPage, endPage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setArray(1, (Array) article.getAuthor());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setInt(3, article.getYear());
            preparedStatement.setInt(4, article.getVolume());
            preparedStatement.setString(5, article.getJournal());
            preparedStatement.setInt(6, article.getNumber());
            preparedStatement.setArray(7, (Array) article.getEe());
            preparedStatement.setString(8, article.getUrl());
            preparedStatement.setInt(9, article.getStartPage());
            preparedStatement.setInt(10, article.getEndPage());


            preparedStatement.executeUpdate();
            System.out.println("Insertion des données réussie !" + "\n\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


