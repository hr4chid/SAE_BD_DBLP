package Classes;

public class Publication {

    private static int compteur = 1;
    private Integer id;
    private String title;
    private Integer year;
    private String venue;
    private Integer nbAuthors;
    private String type;

    public Publication(String title, Integer year, String venue, Integer nbAuthors, String type) {
        this.id = compteur;
        this.title = title;
        this.year = year;
        this.venue = venue;
        this.nbAuthors = nbAuthors;
        this.type = type;
        compteur++;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getVenue() {
        return venue;
    }

    public Integer getNbAuthors() {
        return nbAuthors;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", venue='" + venue + '\'' +
                ", nbAuthors=" + nbAuthors +
                ", type='" + type + '\'' +
                '}';
    }

}
