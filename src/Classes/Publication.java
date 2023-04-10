package Classes;

public class Publication {

    private static int compteur = 1;
    private int id;
    private String title;
    private int year;
    private String venue;
    private int nbAuthors;
    private String type;

    public Publication(String title, int year, String venue, int nbAuthors, String type) {
        this.id = compteur;
        this.title = title;
        this.year = year;
        this.venue = venue;
        this.nbAuthors = nbAuthors;
        this.type = type;
        compteur++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getVenue() {
        return venue;
    }

    public int getNbAuthors() {
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
