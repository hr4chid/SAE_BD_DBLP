package ClasseDAO;

import Classes.Auteur;
import Initializer.DBConnector;
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
            String query = "INSERT INTO dblp.authors (id, name, firstpaper, lastpaper, affiliation) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, author.getId());
            preparedStatement.setString(2, author.getName());
            preparedStatement.setInt(3, author.getFirstpaper());
            preparedStatement.setInt(4, author.getLastpaper());
            preparedStatement.setInt(5, author.getAffiliation());
            preparedStatement.executeUpdate();
        } else {
            System.out.println("Auteur avec l'identifiant " + author.getId() + " existe déjà dans la base de données !");
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
                System.out.println("\n" + "Récupération de l'id réussie !");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


}

