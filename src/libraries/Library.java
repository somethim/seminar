package libraries;

import java.util.ArrayList;

public class Library {
    private static final ArrayList<Library> libraryList = new ArrayList<>();
    private static int lastId = 0;
    protected int id;
    protected String name;

    public Library(String name) {
        id = lastId++;
        this.name = name;
        libraryList.add(this);
    }

    public static int getLastId() {
        return lastId;
    }

    public static void getAttributes(Library library) {
        System.out.println("ID: " + library.id + " Name: " + library.name);
    }

    public static void relatedBooks(Library library) {
        for (Book book : Book.bookList) {
            if (book.libraryID == library.id) {
                Book.getAttributes(book);
            }
        }
    }

    public static Library[] libraries() {
        return libraryList.toArray(new Library[0]);
    }

    public int getId() {
        return id;
    }
}