package fa.training.ex2;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(
                new Book("The alchemist",
                        Collections.singletonList("Paulo Cello"),
                        "NXB",
                        242,
                        12.5));
        library.addBook(
                new Book("The Godfather",
                        Collections.singletonList("Mario Puzo"),
                        "Italio",
                        532,
                        22.5));
        library.addBook(
                new Book("Gone with the wind",
                        Collections.singletonList("Lucida"),
                        "Sybex",
                        412,
                        12.5));

        library.removeBook(library.findBookByTitle("The alchemist").orElse(new Book()));
        System.out.println(library);
    }
}
