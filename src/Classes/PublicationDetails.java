package Classes;

public class PublicationDetails {

    private Integer idPublication;
    private Integer authors;
    private String mdate;
    private String key_id;

    public PublicationDetails(Integer idPublication, Integer authors, String mdate, String key_id) {
        this.idPublication = idPublication;
        this.authors = authors;
        this.mdate = mdate;
        this.key_id = key_id;
    }

    public Integer getIdPublication() {
        return idPublication;
    }

    public Integer getAuthors() {
        return authors;
    }

    public String getMdate() {
        return mdate;
    }

    public String getKey_id() {
        return key_id;
    }

    @Override
    public String toString() {
        return "PublicationDetails{" +
                "idPublication=" + idPublication +
                ", authors=" + authors +
                ", mdate='" + mdate + '\'' +
                ", key_id='" + key_id + '\'' +
                '}';
    }

}
