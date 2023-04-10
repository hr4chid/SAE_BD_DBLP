package Classes;

public class Affiliation {

    private static int compteur = 1;
    private Integer id;
    private String name;
    private String country;

    public Affiliation(String name, String country) {
        this.id = compteur;
        this.name = name;
        this.country = country;
        compteur++;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Affiliation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }


}
