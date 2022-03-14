package Entity;

import java.time.LocalDate;
import java.util.Date;

public class IssuedBook {

    private Long id;

    private String book;

    private String user;

    private Date issueDate;

    private int numberOfDays;

    public IssuedBook() {
    }

    public IssuedBook(Long id, String book, String user, Date issueDate, int numberOfDays) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.issueDate = issueDate;
        this.numberOfDays = numberOfDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }
}
