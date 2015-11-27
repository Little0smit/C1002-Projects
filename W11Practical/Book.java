import java.util.ArrayList;
import java.util.List;

/**
 * Created by ds221 on 26/11/15.
 */
public class Book extends Item {
    private List<Author> author = new ArrayList<>();
    private String publisher;
    private int ISBN;
    private Genre genre;
    private String publicationDate;
    private String format;

    public Book(int itemCode, String name, int stockQuantity, double price, Author author, String publisher, int ISBN, Genre genre, String publicationDate, String format) {
        super(itemCode, name, stockQuantity, price);
        this.author.add(author);
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.format = format;
    }

    public List<Author> getAuthor() {
        return author;
    }
    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getISBN() {
        return ISBN;
    }
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getPublicationDate() {
        return publicationDate;
    }
    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getType() {
        return format;
    }
    public void setType(String format) {
        this.format = format;
    }

    public void printDetails() {
        System.out.print(this.getName() + "\nWritten by: ");
        for(Author a: author) {
            System.out.println(a.getName());
        }
        System.out.println("has a genre of " + this.genre + " an ISBN of " + this.ISBN + "\nPublished by: " + this.publisher
         + " in " + this.publicationDate + "\nAvailable in " + this.format+ "\n");
    }

    public void printDetails(Genre genre) {
        if(this.genre == genre) {
            System.out.print(this.getName() + "\nWritten by: ");
            for (Author a : author) {
                System.out.println(a.getName());
            }
            System.out.println("has a genre of " + this.genre + " an ISBN of " + this.ISBN + "\nPublished by: " + this.publisher
                    + " in " + this.publicationDate + "\nAvailable in " + this.format + "\n");
        }
    }
}

