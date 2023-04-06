package Classes;

import java.sql.Array;
import java.util.List;

public class Article {
    private List<String> author;
    private String title;

    private int pages;
    private int year;

    private int volume;

    private String journal;

    private int number;
    private List<String> ee;

    private String url;

    public Article(List<String> author, String title, int page, int year, int volume, String journal, int number, List<String> ee, String url) {
        this.author = author;
        this.title = title;
        this.pages = page;
        this.year = year;
        this.volume = volume;
        this.journal = journal;
        this.number = number;
        this.ee = ee;
        this.url = url;
    }

    public Array getAuthor() {
        return (Array) author;
    }

    public String getTitle() {
        return title;
    }

    public int getPage() {
        return pages;
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

    @Override
    public String toString() {
        return "Article{" +
                "author=" + author +
                ", title='" + title + '\'' +
                ", page=" + pages +
                ", year=" + year +
                ", volume=" + volume +
                ", journal='" + journal + '\'' +
                ", number=" + number +
                ", ee=" + ee +
                ", url='" + url + '\'' +
                '}';
    }


}
