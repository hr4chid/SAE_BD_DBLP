package Main;

import ClasseDAO.AffiliationDAO;
import ClasseDAO.AuteurDAO;
import ClasseDAO.PublicationDAO;
import Classes.Affiliation;
import Classes.Auteur;
import Classes.Publication;
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
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

            // Traitement des données
            PublicationDAO publicationDAO = new PublicationDAO();
            AffiliationDAO affiliationDAO = new AffiliationDAO();
            AuteurDAO autheurDAO = new AuteurDAO();

            NodeList dblpList = document.getElementsByTagName("dblp");
                for (int i = 0; i < dblpList.getLength(); i++) {
                    Element dblpNode = (Element) dblpList.item(i);

                    // Traitement publications des datas
                    NodeList dataList = dblpNode.getElementsByTagName("data");
                    for (int j = 0; j < dataList.getLength(); j++) {
                        Publication publicationData = null;
                        Element dataNode = (Element) dataList.item(j);

                        NodeList authorDataList = dataNode.getElementsByTagName("author");
                        int nbAuthorsData = authorDataList.getLength();

                        String titleData = dataNode.getElementsByTagName("title").item(0).getTextContent();
                        int yearData = Integer.parseInt(dataNode.getElementsByTagName("year").item(0).getTextContent());
                        String venueData = dataNode.getElementsByTagName("publisher").item(0).getTextContent();
                        String typeData = "Data";

                        publicationData = new Publication(titleData, yearData, venueData, nbAuthorsData, typeData);
                        System.out.println("\n" + publicationData.toString());
                        publicationDAO.insertPublication(publicationData);
                    }


                    // Traitement publications des articles
                    NodeList articleList = dblpNode.getElementsByTagName("article");
                    for (int a = 0; a < articleList.getLength(); a++) {
                        Publication publicationArticle = null;
                        Element ArticleNode = (Element) articleList.item(a);

                        NodeList authorArticleList = ArticleNode.getElementsByTagName("author");
                        int nbAuthorsArticle = authorArticleList.getLength();

                        String titleArticle = ArticleNode.getElementsByTagName("title").item(0).getTextContent();
                        int yearArticle = Integer.parseInt(ArticleNode.getElementsByTagName("year").item(0).getTextContent());
                        String typeArticle = "Article";

                        NodeList journalList = ArticleNode.getElementsByTagName("journal");
                        String venueArticle;
                        if (journalList.getLength() > 0) {
                            venueArticle = journalList.item(0).getTextContent();
                        } else {
                            venueArticle = null;
                        }

                        publicationArticle = new Publication(titleArticle, yearArticle, venueArticle, nbAuthorsArticle, typeArticle);
                        System.out.println("\n" + publicationArticle.toString());
                        publicationDAO.insertPublication(publicationArticle);
                    }


                    // Traitement publications des phdthesis
                    NodeList phdthesisList = dblpNode.getElementsByTagName("phdthesis");
                    for (int z = 0; z < phdthesisList.getLength(); z++) {
                        Publication publicationPhdthesis = null;
                        Element phdthesisNode = (Element) phdthesisList.item(z);

                        NodeList authorPhdthesisList = phdthesisNode.getElementsByTagName("author");
                        int nbAuthorsPhdthesis = authorPhdthesisList.getLength();

                        String titlePhdthesis = phdthesisNode.getElementsByTagName("title").item(0).getTextContent();
                        int yearPhdthesis = Integer.parseInt(phdthesisNode.getElementsByTagName("year").item(0).getTextContent());
                        String typePhdthesis = "Phdthesis";

                        NodeList publisherPhdthesisList = phdthesisNode.getElementsByTagName("publisher");
                        String venuePhdthesis;
                        if (publisherPhdthesisList.getLength() > 0) {
                            venuePhdthesis = publisherPhdthesisList.item(0).getTextContent();
                        } else {
                            venuePhdthesis = null;
                        }

                        publicationPhdthesis = new Publication(titlePhdthesis, yearPhdthesis, venuePhdthesis, nbAuthorsPhdthesis, typePhdthesis);
                        System.out.println("\n" + publicationPhdthesis.toString());
                        publicationDAO.insertPublication(publicationPhdthesis);
                    }


                    // Traitement publications des books
                    NodeList bookList = dblpNode.getElementsByTagName("book");
                    for (int b = 0; b < bookList.getLength(); b++) {
                        Publication publicationBook = null;
                        Element bookNode = (Element) bookList.item(b);

                        NodeList authorBookList = bookNode.getElementsByTagName("author");
                        int nbAuthorsBook = authorBookList.getLength();

                        String titleBook = bookNode.getElementsByTagName("title").item(0).getTextContent();
                        int yearBook = Integer.parseInt(bookNode.getElementsByTagName("year").item(0).getTextContent());
                        String typePhdthesis = "Book";

                        NodeList publisherBookList = bookNode.getElementsByTagName("publisher");
                        String venueBook;
                        if (publisherBookList.getLength() > 0) {
                            venueBook = publisherBookList.item(0).getTextContent();
                        } else {
                            venueBook = null;
                        }

                        publicationBook = new Publication(titleBook, yearBook, venueBook, nbAuthorsBook, typePhdthesis);
                        System.out.println("\n" + publicationBook.toString());
                        publicationDAO.insertPublication(publicationBook);
                    }


                    // Traitement publications des incollections
                    NodeList incollectionList = dblpNode.getElementsByTagName("incollection");
                    for (int c = 0; c < incollectionList.getLength(); c++) {
                        Publication publicationIncollection = null;
                        Element incollectionNode = (Element) incollectionList.item(c);

                        NodeList authorIncollectionList = incollectionNode.getElementsByTagName("author");
                        int nbAuthorsauthorIncollection = authorIncollectionList.getLength();

                        String titleIncollection = incollectionNode.getElementsByTagName("title").item(0).getTextContent();
                        int yearIncollection = Integer.parseInt(incollectionNode.getElementsByTagName("year").item(0).getTextContent());
                        String typeIncollection = "Encyclopedia";

                        NodeList bookTitleList = incollectionNode.getElementsByTagName("booktitle");
                        String venueIncollection;
                        if (bookTitleList.getLength() > 0) {
                            venueIncollection = bookTitleList.item(0).getTextContent();
                        } else {
                            venueIncollection = null;
                        }

                        publicationIncollection = new Publication(titleIncollection, yearIncollection, venueIncollection, nbAuthorsauthorIncollection, typeIncollection);
                        System.out.println("\n" + publicationIncollection.toString());
                        publicationDAO.insertPublication(publicationIncollection);
                    }


                    // Traitement publications des wwws
                    NodeList wwwList = dblpNode.getElementsByTagName("www");
                    for (int w = 0; w < wwwList.getLength(); w++) {
                        Publication publicationWww = null;
                        Element wwwNode = (Element) wwwList.item(w);

                        NodeList authorWwwList = wwwNode.getElementsByTagName("author");
                        NodeList editorWwwList = wwwNode.getElementsByTagName("editor");
                        int nbAuthorsWww = 0;
                        if (authorWwwList.getLength() > 0) {
                            nbAuthorsWww = authorWwwList.getLength();
                        } else if (editorWwwList.getLength() > 0) {
                            nbAuthorsWww = editorWwwList.getLength();
                        }

                        String titleWww = wwwNode.getElementsByTagName("title").item(0).getTextContent();
                        String venueWww = null;
                        String typeWww = "Home Page";

                        NodeList yearWwwList = wwwNode.getElementsByTagName("year");
                        int yearWww;
                        if (yearWwwList.getLength() > 0) {
                            yearWww = Integer.parseInt(yearWwwList.item(0).getTextContent());
                        } else {
                            yearWww = 0;
                        }

                        publicationWww = new Publication(titleWww, yearWww, venueWww, nbAuthorsWww, typeWww);
                        System.out.println("\n" + publicationWww.toString());
                        publicationDAO.insertPublication(publicationWww);
                    }


                    // Traitement publications des inproceedings
                    NodeList inproceedingsList = dblpNode.getElementsByTagName("inproceedings");
                    for (int p = 0; p < inproceedingsList.getLength(); p++) {
                        Publication publicationInproceedings = null;
                        Element inproceedingsNode = (Element) inproceedingsList.item(p);

                        NodeList authorinproceedingsList = inproceedingsNode.getElementsByTagName("author");
                        int nbAuthorInproceedings = authorinproceedingsList.getLength();

                        String titleInproceedings = inproceedingsNode.getElementsByTagName("title").item(0).getTextContent();
                        int yearInproceedings = Integer.parseInt(inproceedingsNode.getElementsByTagName("year").item(0).getTextContent());
                        String typeInproceedings = "Inproceedings";

                        NodeList bookTitleInproceedingsList = inproceedingsNode.getElementsByTagName("booktitle");
                        String venueInproceedings;
                        if (bookTitleInproceedingsList.getLength() > 0) {
                            venueInproceedings = bookTitleInproceedingsList.item(0).getTextContent();
                        } else {
                            venueInproceedings = null;
                        }

                        publicationInproceedings = new Publication(titleInproceedings, yearInproceedings, venueInproceedings, nbAuthorInproceedings, typeInproceedings);
                        System.out.println("\n" + publicationInproceedings.toString());
                        publicationDAO.insertPublication(publicationInproceedings);
                    }


                    // Traitement publications des mastersthesis
                    NodeList mastersthesisList = dblpNode.getElementsByTagName("mastersthesis");
                    for (int m = 0; m < mastersthesisList.getLength(); m++) {
                        Publication publicationMastersthesis = null;
                        Element mastersthesisNode = (Element) mastersthesisList.item(m);

                        NodeList authorMastersthesisList = mastersthesisNode.getElementsByTagName("author");
                        int nbAuthorMastersthesis = authorMastersthesisList.getLength();

                        String titleMastersthesis = mastersthesisNode.getElementsByTagName("title").item(0).getTextContent();
                        int yearMastersthesis = Integer.parseInt(mastersthesisNode.getElementsByTagName("year").item(0).getTextContent());
                        String typeMastersthesis = "Mastersthesis";
                        String venueMastersthesis = null;

                        publicationMastersthesis = new Publication(titleMastersthesis, yearMastersthesis, venueMastersthesis, nbAuthorMastersthesis, typeMastersthesis);
                        System.out.println("\n" + publicationMastersthesis.toString());
                        publicationDAO.insertPublication(publicationMastersthesis);
                    }


                    // Traitement publications des proceedings
                    NodeList proceedingsList = dblpNode.getElementsByTagName("proceedings");
                    for (int d = 0; d < proceedingsList.getLength(); d++) {
                        Publication publicationProceedings = null;
                        Element proceedingsNode = (Element) proceedingsList.item(d);

                        NodeList authorProceedingsList = proceedingsNode.getElementsByTagName("author");
                        NodeList editorProceedingsList = proceedingsNode.getElementsByTagName("editor");
                        int nbAuthorsProceedings = 0;
                        if (authorProceedingsList.getLength() > 0) {
                            nbAuthorsProceedings = authorProceedingsList.getLength();
                        } else if (editorProceedingsList.getLength() > 0) {
                            nbAuthorsProceedings = editorProceedingsList.getLength();
                        }

                        String titleProceedings = proceedingsNode.getElementsByTagName("title").item(0).getTextContent();
                        int yearProceedings = Integer.parseInt(proceedingsNode.getElementsByTagName("year").item(0).getTextContent());
                        String typeProceedings = "Proceedings";

                        NodeList publisherProceedingsList = proceedingsNode.getElementsByTagName("publisher");
                        String venueProceedings;
                        if (publisherProceedingsList.getLength() > 0) {
                            venueProceedings = publisherProceedingsList.item(0).getTextContent();
                        } else {
                            venueProceedings = null;
                        }

                        publicationProceedings = new Publication(titleProceedings, yearProceedings, venueProceedings, nbAuthorsProceedings, typeProceedings);
                        System.out.println("\n" + publicationProceedings.toString());
                        publicationDAO.insertPublication(publicationProceedings);
                    }


                    // Traitement des affiliations
                    NodeList nodeAffiliationList = dblpNode.getElementsByTagName("note");
                    for (int z = 0; z < nodeAffiliationList.getLength(); z++) {
                        Affiliation affiliation = null;
                        Node node = nodeAffiliationList.item(z);

                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) node;
                            String type = element.getAttribute("type");
                            if (type.equals("affiliation")) {
                                String aff = element.getTextContent();

                                String[] parts = aff.split(",");
                                String nameAffiliation = String.join(",", Arrays.copyOfRange(parts, 0, parts.length - 1)).trim(); // La variable name sera "University of Tokyo, School of Engineering, Department of Bioengineering, Tokyo"
                                String countryAffiliation = parts[parts.length - 1].trim();

                                affiliation = new Affiliation(nameAffiliation, countryAffiliation);
                                System.out.println("\n" + affiliation.toString());
                                affiliationDAO.insertAffiliation(affiliation);
                            }
                        }
                    }


                    // Traitement des auteurs
                    NodeList nodeAuteursList = dblpNode.getElementsByTagName("author");
                    List<Auteur> auteurs = new ArrayList<Auteur>();

                    for (int l = 0; l < nodeAuteursList.getLength(); l++) {
                        Node auteurNode = nodeAuteursList.item(l);

                        String nom = auteurNode.getTextContent();
                        Auteur auteur = new Auteur(nom, 0, 0, 0);
                        auteurs.add(auteur);
                    }

                    for (Auteur auteur : auteurs) {
                        System.out.println("\n" + auteur.toString());
                        autheurDAO.insertAutheur(auteur);
                    }

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
