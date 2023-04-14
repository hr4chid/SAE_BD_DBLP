package ClassesDAO;

import ClassesObject.Auteur;
import Initializers.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuteurDAO {
    private DBConnector DBconnector;
    private Connection connection;

    public AuteurDAO() throws ClassNotFoundException {
        this.DBconnector = new DBConnector();
        this.connection = DBconnector.getConnection();
    }

    public boolean authorExists(int id) throws SQLException {
        String query = "SELECT id FROM dblp.authors WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public void insertAutheur(Auteur author) throws SQLException {
        if (!authorExists(author.getId())) {
            String query = "INSERT INTO dblp.authors (id, name, firstpaper, lastpaper, affiliation) VALUES (?, ?, null, null, null)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, author.getId());
            preparedStatement.setString(2, author.getName());
            preparedStatement.executeUpdate();

            System.out.println("Auteur inséré avec succès !");

        } else {
            System.out.println("L'auteur avec l'identifiant " + author.getId() + " existe déjà dans la base de données !");
        }
    }


    public Integer getIdAuteur(String nom) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Integer id = null;
        try {
            preparedStatement = this.connection.prepareStatement("SELECT id FROM dblp.authors WHERE name = ?");
            preparedStatement.setString(1, nom);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id");
                System.out.println("Récupération de l'id réussie !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


    public void updateFirstPaperAuthor () throws SQLException {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("" +
                    "UPDATE dblp.authors author " +
                    "SET firstpaper = " +
                    "(SELECT MIN(p.year) FROM dblp.publications p INNER JOIN dblp.publicationauthors pauthor " +
                    "ON pauthor.publication_id = p.id WHERE pauthor.author_id = author.id)");

            preparedStatement.executeUpdate();
            System.out.println("\n" + "FirstPaper mis à jour");

        } catch (SQLException e){
                e.printStackTrace();
        }

    }

    public void updateLastPaperAuthor () throws SQLException {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement("" +
                    "UPDATE dblp.authors author " +
                    "SET lastpaper = " +
                    "(SELECT MAX(p.year) FROM dblp.publications p INNER JOIN dblp.publicationauthors pauthor " +
                    "ON pauthor.publication_id = p.id WHERE pauthor.author_id = author.id)");

            preparedStatement.executeUpdate();
            System.out.println("\n" + "LastPaper mis à jour");

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateAuthorAffiliations() throws SQLException {
        //TODO
    }

}

