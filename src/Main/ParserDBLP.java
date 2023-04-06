package Main;

import ClasseDAO.ArticlesDAO;
import ClasseDAO.AutheurDAO;
import Classes.Article;
import Classes.Autheur;
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
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;;

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


            // Traitement des articles
            ArticlesDAO articlesDAO = new ArticlesDAO();
            NodeList articleList = document.getElementsByTagName("article");

            for (int i = 0; i < articleList.getLength(); i++) {
                Article article = null;
                Element articleNode = (Element) articleList.item(i);

                List<String> authors = new ArrayList<String>();
                NodeList authorList = articleNode.getElementsByTagName("author");
                for (int j = 0; j < authorList.getLength(); j++) {
                    Element authorNode = (Element) authorList.item(j);
                    String author = authorNode.getTextContent();
                    authors.add(author);
                }

                String title = articleNode.getElementsByTagName("title").item(0).getTextContent();
                int pages = Integer.parseInt(articleNode.getElementsByTagName("pages").item(0).getTextContent());
                int year = Integer.parseInt(articleNode.getElementsByTagName("year").item(0).getTextContent());
                int volume = Integer.parseInt(articleNode.getElementsByTagName("volume").item(0).getTextContent());
                String journal = articleNode.getElementsByTagName("journal").item(0).getTextContent();
                int number = Integer.parseInt(articleNode.getElementsByTagName("number").item(0).getTextContent());

                List<String> ees = new ArrayList<String>();
                NodeList eeList = articleNode.getElementsByTagName("ee");
                for (int y = 0; y < eeList.getLength(); y++) {
                    Element eeNode = (Element) authorList.item(y);
                    String ee = eeNode.getTextContent();
                    ees.add(ee);
                }

                String url = articleNode.getElementsByTagName("url").item(0).getTextContent();

                article = new Article(authors, title, pages, year, volume, journal, number, ees, url);
                System.out.println("\n\n" + article.toString() + "");
                //articlesDAO.insertArticle(article);
            }

            // Traitement des autheurs
            /*AutheurDAO autheurDAO = new AutheurDAO();
            NodeList dblpList = document.getElementsByTagName("dblp");

            for(int k = 0; k < dblpList.getLength(); k++){
                Element dblpNode = (Element) dblpList.item(k);

                NodeList authorList = dblpNode.getElementsByTagName("author");
                for(int i = 0; i < authorList.getLength(); i++) {
                    Autheur autheur = null;

                    String author = authorList.item(i).getTextContent();
                    autheur = new Autheur(author, 1, 5, null);
                    System.out.println("\n" + author + "\n");
                    autheurDAO.insertAutheur(autheur);
                }
            }*/


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in XML file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
