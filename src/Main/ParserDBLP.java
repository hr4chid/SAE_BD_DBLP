package Main;

import Classes.Article;
import Initializer.DBConnector;
import Initializer.LoadXML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;

public class ParserDBLP {
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedEncodingException {
        // Encodage UTF-8
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        // Connection JDBC
        DBConnector connector = new DBConnector();
        Connection connection = connector.getConnection();

        // Chargement fichier XML
        String pathFile = "R:/BUT INFO/MOODLE/S4/PARCOURS C/SAE BD/SAE_BD_DBLP/src/Files/dblp.xml";
        Document document = null;
        try {
            File dataFile = new File(pathFile);
            document = LoadXML.loadXML(dataFile);
            System.out.println("Le fichier à bien été chargé ! \n\n");
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        // Traitement fichier XML ici
        /*NodeList nodeList = document.getElementsByTagName("data");
        Article article = null;*/

        NodeList dataList = document.getElementsByTagName("data");
        for (int i = 0; i < dataList.getLength(); i++) {
            Element dataNode = (Element) dataList.item(i);
            NodeList titleList = dataNode.getElementsByTagName("title");
            Element titleElement = (Element) titleList.item(0);
            String title = titleElement.getTextContent();
            System.out.println("Title: " + title);
        }

        /*for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String author = element.getElementsByTagName("author").item(0).getTextContent();
                String title = element.getElementsByTagName("title").item(0).getTextContent();
                String year = element.getElementsByTagName("year").item(0).getTextContent();
                String month = element.getElementsByTagName("month").item(0).getTextContent();
                String ee = element.getElementsByTagName("ee").item(0).getTextContent();
                String publisher = element.getElementsByTagName("publisher").item(0).getTextContent();

                article = new Article(author, title, Integer.parseInt(year), month, ee, publisher);
                article.toString();
                //articleDAO.insert(article);
            }
        }*/

    }
}
