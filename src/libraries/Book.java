package libraries;

import java.util.ArrayList;

public class Book {
    protected static final ArrayList<Book> bookList = new ArrayList<>();
    protected String title;
    protected String author;
    protected String ISBN;
    protected int libraryID;

    public Book(String title, String author, String ISBN, int libraryID) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.libraryID = libraryID;
        bookList.add(this);
    }


    public static ArrayList<Book> getBookList() {
        return bookList;
    }

    public static void getAttributes(Book book) {
        System.out.println("Title: " + book.title + " Author: " + book.author + " ISBN: " + book.ISBN + " Library ID: " + book.libraryID);
    }
}
