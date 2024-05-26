package model;

import java.time.LocalDate;
import java.util.Set;

public class Author extends User {

    private User user;
    private String bio;
    private Set<Book> books;

    public Author(String name, String surname, String email, String password, String address, LocalDate birthDate) {
        super(name, surname, email, password, address, birthDate);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "user=" + user +
                ", bio='" + bio + '\'' +
                ", books=" + books +
                '}';
    }
}
