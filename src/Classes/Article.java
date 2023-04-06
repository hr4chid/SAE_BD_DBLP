package Classes;

import java.sql.Array;
import java.util.List;

public class Article {
    private List<String> author;
    private String title;

    private int year;

    private int volume;

    private String journal;

    private int number;
    private List<String> ee;

    private String url;

    private int startPage;

    private int endPage;

    public Article(List<String> author, String title, int year, int volume, String journal, int number, List<String> ee, String url, int startPage, int endPage) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.volume = volume;
        this.journal = journal;
        this.number = number;
        this.ee = ee;
        this.url = url;
        this.startPage = startPage;
        this.endPage = endPage;
    }

    public List<String> getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getVolume() {
        return volume;
    }

    public String getJournal() {
        return journal;
    }

    public int getNumber() {
        return number;
    }

    public List<String> getEe() {
        return ee;
    }

    public String getUrl() {
        return url;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    @Override
    public String toString() {
        return "Article{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", volume=" + volume +
                ", journal='" + journal + '\'' +
                ", number=" + number +
                ", ee=" + ee +
                ", url='" + url + '\'' +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                '}';
    }


}
