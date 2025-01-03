package example_stream;

import java.util.HashSet;
import java.util.Set;

public class Developer {

    private Integer id;
    private String name;
    private Set<String> book;

    //getters, setters, toString
    public void setName(String name) {
        this.name = name;
    }

    public Set<String> getBook() {
        return book;
    }

    public void addBook(String book) {
        if (this.book == null) {
            this.book = new HashSet<>();
        }
        this.book.add(book);
    }
}
