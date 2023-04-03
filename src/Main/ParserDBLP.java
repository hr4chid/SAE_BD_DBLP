package Main;

import ClasseDAO.ArticlesDAO;
import Classes.Article;
import Initializer.DBConnector;
import Initializer.LoadXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;;

public class ParserDBLP {
    public static void main(String[] args) {
        try {
            // Encodage UTF-8
            System.setOut(new PrintStream(System.out, true, "UTF-8"));


            // Connection JDBC
            DBConnector DBconnector = new DBConnector();
            Connection connection = DBconnector.getConnection();


            // Chargement fichier XML
            File dataFile = new File("C:/Users/rachi/eclipse-workspace/SAE_BD_DBLP_GIT/src/Files/dblp.xml");
            Document document = LoadXML.loadXML(dataFile);
            document.getDocumentElement().normalize();


            // Traitement fichier XML ici
            ArticlesDAO articlesDAO = new ArticlesDAO();
            NodeList dataList = document.getElementsByTagName("data");
            for (int i = 0; i < dataList.getLength(); i++) {
                Article article = null;
                Element dataNode = (Element) dataList.item(i);

                String author = dataNode.getElementsByTagName("author").item(0).getTextContent();
                String title = dataNode.getElementsByTagName("title").item(0).getTextContent();
                int year = Integer.parseInt(dataNode.getElementsByTagName("year").item(0).getTextContent());
                String month = dataNode.getElementsByTagName("month").item(0).getTextContent();
                String ee = dataNode.getElementsByTagName("ee").item(0).getTextContent();
                String publisher = dataNode.getElementsByTagName("publisher").item(0).getTextContent();

                System.out.println("\nAuthor: " + author + "\nTitle: " + title + "\nYear: " + year + "\nMonth: " + month + "\nEE: " + ee + "\nPublisher: " + publisher + "\n");
                article = new Article(author, title, year, month, ee, publisher);
                articlesDAO.insertArticle(article);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in XML file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
