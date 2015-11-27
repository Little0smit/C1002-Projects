import java.util.ArrayList;
import java.util.List;

/**
 * Created by ds221 on 26/11/15.
 */
public class Author {
    private String name;
    private String address;
    private List<Genre> genres = new ArrayList<>();
    private int agentContactNo;

    public Author(String name, String address, int agentContactNo) {
        this.name = name;
        this.address = address;
        this.agentContactNo = agentContactNo;
    }
    public Author() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public List<Genre> getGenres() {
        return genres;
    }
    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public int getAgentContactNo() {
        return agentContactNo;
    }
    public void setAgentContactNo(int agentContactNo) {
        this.agentContactNo = agentContactNo;
    }
}
