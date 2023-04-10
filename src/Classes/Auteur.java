package Classes;

public class Auteur {

    private static int compteur = 1;
    private Integer id;
    private String name;
    private Integer firstpaper;
    private Integer lastpaper;
    private Integer affiliation;

    public Auteur(String name, int firstpaper, int lastpaper, int affiliation) {
        this.id = compteur;
        this.name = name;
        this.firstpaper = firstpaper;
        this.lastpaper = lastpaper;
        this.affiliation = affiliation;
        compteur++;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getFirstpaper() {
        return firstpaper;
    }

    public Integer getLastpaper() {
        return lastpaper;
    }

    public Integer getAffiliation() {
        return affiliation;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstpaper=" + firstpaper +
                ", lastpaper=" + lastpaper +
                ", affiliation=" + affiliation +
                '}';
    }
}
