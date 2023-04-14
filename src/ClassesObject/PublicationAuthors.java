package ClassesObject;

public class PublicationAuthors {

    private Integer authorId;
    private Integer publicationId;

    public PublicationAuthors(Integer author_id, Integer publication_id) {
        this.authorId = author_id;
        this.publicationId = publication_id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public Integer getPublicationId() {
        return publicationId;
    }

    @Override
    public String toString() {
        return "PublicationAuthors{" +
                "author_id=" + authorId +
                ", publication_id=" + publicationId +
                '}';
    }

}
