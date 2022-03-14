import Entity.Book;
import Entity.IssuedBook;
import Entity.User;
import Service.BookService;
import Service.IssueBookService;
import Service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagement {

    static Scanner sc = new Scanner(System.in);
    private final UserService userService;
    private final BookService bookService;
    private final IssueBookService issueBookService;

    public LibraryManagement(UserService userService, BookService bookService, IssueBookService issueBookService) {
        this.userService = userService;
        this.bookService = bookService;
        this.issueBookService = issueBookService;
    }

    public static void main(String[] args) {

        System.out.println("-----Welcome To Library Management Portal-----");
        System.out.println("");

        List<User> userList = new ArrayList<>();
        List<Book> bookList = new ArrayList<>();
        List<IssuedBook> issuedBookList = new ArrayList<>();
        UserService userService = new UserService();
        BookService bookService = new BookService();
        IssueBookService issueBookService = new IssueBookService();


        boolean flag = true;
        while (flag==true){
            int select = selectOperation();
            switch (select){
                case 0:
                    flag = false;
                    break;
                case 1:
                    userList = userService.addUser(userList);
                    continue;
                case 2:
                    bookList = bookService.addBook(bookList);
                    continue;
                case 3:
                    bookList = bookService.removeBook(bookList);
                    continue;
                case 4:
                    System.out.print("Please enter the book name to be searched : ");
                    Book book = bookService.searchBook(bookList, sc.next());
                    continue;
                case 5:
                    System.out.print("Please enter the book name to be searched : ");
                    issuedBookList = issueBookService.issueBook(issuedBookList, bookList, sc.next());
                    continue;
                case 7:
                    bookList = bookService.rateBook(bookList);
                    continue;
                default:
                    System.out.println("Invalid input please try again");
                    continue;
            }
        }


    }

    private static int selectOperation() {
        System.out.println("To add a new user enter 1 : ");
        System.out.println("To add a new book enter 2 : ");
        System.out.println("To remove a book enter 3 : ");
        System.out.println("To search for a book enter 4 : ");
        System.out.println("To issue a book enter 5 : ");
        System.out.println("To rate a book enter 7 : ");
        return sc.nextInt();
    }
}
