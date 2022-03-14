package Entity;

import java.util.List;

public class Book {

    private Long id;

    private String name;

    private List<String> authorList;

    private int copy;

    private String rate;

    public Book() {
    }

    public Book(Long id, String name, List<String> authorList, int copy, String rate) {
        this.id = id;
        this.name = name;
        this.authorList = authorList;
        this.copy = copy;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<String> authorList) {
        this.authorList = authorList;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
