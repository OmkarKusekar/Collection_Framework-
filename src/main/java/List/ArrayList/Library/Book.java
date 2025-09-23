package main.java.List.ArrayList.Library;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private String isbn;

    public Book(String title , String author, String isbn){
        if(title == null || title.trim().isEmpty() || author == null || author.trim().isEmpty() || isbn == null || isbn.trim().isEmpty()){
            throw new IllegalArgumentException("Title , Author and ISBN cannot be null or empty ");
        }
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getIsbn(){
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
