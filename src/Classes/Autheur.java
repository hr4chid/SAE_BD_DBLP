package Classes;

public class Autheur {

    private static int compteur = 0;
    private int id;
    private String name;
    private int firstpaper;
    private int lastpaper;
    private Affiliation affiliation;

    public Autheur(String name, int firstpaper, int lastpaper, Affiliation affiliation) {
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

    public Affiliation getAffiliation() {
        return affiliation;
    }

    @Override
    public String toString() {
        return "Autheur{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstpaper=" + firstpaper +
                ", lastpaper=" + lastpaper +
                ", affiliation=" + affiliation +
                '}';
    }
}
