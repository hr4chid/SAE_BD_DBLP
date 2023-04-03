package Classes;

import java.util.List;

public class Article {

    private List <String> authors;
    private String title;
    private int year;
    private String month;
    private String ee;
    private String publisher;

    public Article(List <String> author, String title, int year, String month, String ee, String publisher) {
        this.authors = author;
        this.title = title;
        this.year = year;
        this.month = month;
        this.ee = ee;
        this.publisher = publisher;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getEe() {
        return ee;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return "Article{" +
                "author='" + authors + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", month='" + month + '\'' +
                ", ee='" + ee + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

}
