package Service;

import Entity.Book;
import com.sun.org.apache.bcel.internal.generic.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BookService {

    static Scanner sc = new Scanner(System.in);

    public List<Book> addBook(List<Book> bookList){
        Book book = new Book();
        book.setId((long) (bookList.size()+1));
        System.out.print("Please enter book name : ");
        book.setName(sc.next());
        book.setAuthorList(getAuthors());
        System.out.print("Please enter no. of copies : ");
        book.setCopy(sc.nextInt());
        bookList.add(book);
        printBooks(bookList);
        return bookList;
    }

    public List<Book> removeBook(List<Book> bookList){
        System.out.print("Please enter book name to be removed :");
        String name = sc.next();
        Book deleteBook = new Book();
        for (Book book: bookList) {
            if(book.getName().equalsIgnoreCase(name)){
                deleteBook = book;
                break;
            }
        }
        if(Objects.nonNull(deleteBook)){
            bookList.remove(deleteBook);
            System.out.println("Book with name "+name+" deleted successfully");
        }
        else{
            System.out.println("Book not found");
        }
        return bookList;
    }

    public Book searchBook(List<Book> bookList, String name){
        Book searchedBook = null;
        for (Book book: bookList) {
            if(book.getName().equalsIgnoreCase(name)){
                searchedBook = book;
                break;
            }
        }
        if(Objects.nonNull(searchedBook)){
            System.out.println("Book found");
            return searchedBook;
        }
        else{
            System.out.println("Book not found");
            return null;
        }
    }

    private void printBooks(List<Book> bookList) {
        System.out.println("Id      Name      Author      Rate      Copies");
        for (Book book : bookList) {
            System.out.println(book.getId()+"      "+book.getName()+"      "+book.getAuthorList()+"      "+book.getRate()+"      "+book.getCopy());
        }
    }

    private List<String> getAuthors() {
        boolean flag = true;
        List<String> authorList = new ArrayList<>();
        while (flag==true){
            System.out.println("To add author enter 1 : ");
            System.out.println("To exit enter 2 : ");
            switch (sc.nextInt()){
                case 1:
                    System.out.println("Please enter the author name : ");
                    authorList.add(sc.next());
                    continue;
                case 2:
                    flag = false;
                    break;
            }
        }
        return authorList;
    }

    public List<Book> rateBook(List<Book> bookList){
        boolean flag = false;
        System.out.println("Please enter the name of book to be rated");
        for (Book book: bookList) {
            if(book.getName().equalsIgnoreCase(sc.next())){
                System.out.println("Please enter book rating");
                String rate = sc.next();
                book.setRate(rate);
                flag = true;
            }
        }
        if(flag==false){
            System.out.println("Book not found");
        }
        printBooks(bookList);
        return bookList;
    }

}
