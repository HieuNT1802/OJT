package fa.training.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public Library(){
        this.books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    public Optional<Book> findBookByTitle(String title){
        return books.stream()
                .filter(book -> title.equals(book.getTitle()))
                .findFirst();
    }
    public boolean addBook(Book book){
        return books.add(book);
    }
    public boolean removeBook(Book book){
        return books.remove(book);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                '}';
    }
}
