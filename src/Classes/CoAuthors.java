package Classes;

public class CoAuthors {

    private Integer authorId;
    private Integer coauthorId;

    public CoAuthors(Integer authorId, Integer coauthorId) {
        this.authorId = authorId;
        this.coauthorId = coauthorId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public Integer getCoauthorId() {
        return coauthorId;
    }

    @Override
    public String toString() {
        return "CoAuthors{" +
                "authorId=" + authorId +
                ", coauthorId=" + coauthorId +
                '}';
    }


}
