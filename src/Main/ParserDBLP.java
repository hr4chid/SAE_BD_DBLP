package Main;

import ClasseDAO.PublicationDAO;
import Classes.Publication;
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

            // Traitement des publications
            PublicationDAO publicationDAO = new PublicationDAO();
            NodeList dblpList = document.getElementsByTagName("dblp");
                for (int i = 0; i < dblpList.getLength(); i++) {
                    Element dblpNode = (Element) dblpList.item(i);

                    // Publications des datas
                    NodeList dataList = dblpNode.getElementsByTagName("data");
                    for (int j = 0; j < dataList.getLength(); j++) {
                        Publication publicationData = null;
                        Element dataNode = (Element) dataList.item(j);

                        String titleData = dataNode.getElementsByTagName("title").item(0).getTextContent();
                        int yearData = Integer.parseInt(dataNode.getElementsByTagName("year").item(0).getTextContent());
                        String venueData = dataNode.getElementsByTagName("publisher").item(0).getTextContent();

                        NodeList authorDataList = dataNode.getElementsByTagName("author");
                        int nbAuthorsData = authorDataList.getLength();

                        NodeList nodeList = dataNode.getElementsByTagName("ee");
                        Element eeElement = (Element) nodeList.item(0);
                        String typeData = null;
                        if (!eeElement.getAttribute("type").isEmpty()) {
                            typeData = eeElement.getAttribute("type");
                        }

                        publicationData = new Publication(titleData, yearData, venueData, nbAuthorsData, typeData);
                        System.out.println("\n" + publicationData.toString());
                        //publicationDAO.insertPublication(publicationData);
                    }

                    // Publications des articles
                    NodeList articleList = dblpNode.getElementsByTagName("article");
                    for (int a = 0; a < articleList.getLength(); a++) {
                        Publication publicationArticle = null;
                        Element ArticleNode = (Element) articleList.item(a);

                        String titleArticle = ArticleNode.getElementsByTagName("title").item(0).getTextContent();
                        int yearArticle = Integer.parseInt(ArticleNode.getElementsByTagName("year").item(0).getTextContent());

                        NodeList journalList = ArticleNode.getElementsByTagName("journal");
                        String venueArticle;
                        if (journalList.getLength() > 0) {
                            venueArticle = journalList.item(0).getTextContent();
                        } else {
                            venueArticle = null;
                        }

                        NodeList authorArticleList = ArticleNode.getElementsByTagName("author");
                        int nbAuthorsArticle = authorArticleList.getLength();

                        NodeList nodeList = ArticleNode.getElementsByTagName("ee");
                        Element eeElement = (Element) nodeList.item(0);
                        String typeArticle = null;
                        if (!eeElement.getAttribute("type").isEmpty()) {
                            typeArticle = eeElement.getAttribute("type");
                        }

                        publicationArticle = new Publication(titleArticle, yearArticle, venueArticle, nbAuthorsArticle, typeArticle);
                        System.out.println("\n" + publicationArticle.toString());
                        //publicationDAO.insertPublication(publicationArticle);
                    }

                    // Publications des phdthesis
                    NodeList phdthesisList = dblpNode.getElementsByTagName("phdthesis");
                    for (int z = 0; z < phdthesisList.getLength(); z++) {
                        Publication publicationPhdthesis = null;
                        Element phdthesisNode = (Element) phdthesisList.item(z);

                        String titlePhdthesis = phdthesisNode.getElementsByTagName("title").item(0).getTextContent();
                        int yearPhdthesis = Integer.parseInt(phdthesisNode.getElementsByTagName("year").item(0).getTextContent());

                        NodeList publisherList = phdthesisNode.getElementsByTagName("publisher");
                        String venuePhdthesis;
                        if (publisherList.getLength() > 0) {
                            venuePhdthesis = publisherList.item(0).getTextContent();
                        } else {
                            venuePhdthesis = null;
                        }

                        NodeList authorPhdthesisList = phdthesisNode.getElementsByTagName("author");
                        int nbAuthorsPhdthesis = authorPhdthesisList.getLength();

                        publicationPhdthesis = new Publication(titlePhdthesis, yearPhdthesis, venuePhdthesis, nbAuthorsPhdthesis, null);
                        System.out.println("\n" + publicationPhdthesis.toString());
                        publicationDAO.insertPublication(publicationPhdthesis);
                    }

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
                    autheur = new Autheur(author, 1, 1, null);
                    System.out.println("\n" + author);
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
