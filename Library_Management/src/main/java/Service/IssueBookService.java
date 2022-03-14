package Service;

import Entity.Book;
import Entity.IssuedBook;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class IssueBookService {

    static Scanner sc = new Scanner(System.in);


    public List<IssuedBook> issueBook(List<IssuedBook> issuedBookList, List<Book> bookList, String name){

        BookService bookService = new BookService();
        Book book = bookService.searchBook(bookList, name);
        if(Objects.nonNull(book)){
            for (Book book1: bookList) {
                if(book1.getName().equalsIgnoreCase(name)){
                    book1.setCopy(book1.getCopy()-1);
                }
            }
            Date date = new Date();
            IssuedBook issuedBook = new IssuedBook();
            issuedBook.setId(date.getTime());
            System.out.print("Please enter user name : ");
            issuedBook.setUser(sc.next());
            System.out.print("Please enter book name : ");
            issuedBook.setBook(sc.next());
            System.out.print("Please enter no. of days : ");
            issuedBook.setNumberOfDays(sc.nextInt());
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            issuedBook.setIssueDate(dateFormat.format(date));
            issuedBookList.add(issuedBook);
            System.out.println("Book issued successfully");
            printIssuedBook(issuedBookList);
        }
        else{
            System.out.println("Book not found");
        }
        return issuedBookList;
    }

//    public void returnBook(List<IssuedBook> issuedBookList)

    private void printIssuedBook(List<IssuedBook> issuedBookList) {
        for (IssuedBook issuedBook: issuedBookList) {
            System.out.println(issuedBook.getId()+"  "+issuedBook.getBook()+"  "+issuedBook.getUser()+"  "+issuedBook.getNumberOfDays());
        }
    }

}
