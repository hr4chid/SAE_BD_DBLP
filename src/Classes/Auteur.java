package Classes;

public class Auteur {

    private static int compteur = 1;
    private int id;
    private String name;
    private int firstpaper;
    private int lastpaper;
    private int affiliation;

    public Auteur(String name, int firstpaper, int lastpaper, int affiliation) {
        this.id = compteur;
        this.name = name;
        this.firstpaper = firstpaper;
        this.lastpaper = lastpaper;
        this.affiliation = affiliation;
        compteur++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFirstpaper() {
        return firstpaper;
    }

    public int getLastpaper() {
        return lastpaper;
    }

    public int getAffiliation() {
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
