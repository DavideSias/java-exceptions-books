package org.lessons.java;

public class Book {
    private String title;
    private int pages;
    private String author;
    private String publisher;

    public Book(String title, int pages, String author, String publisher) throws InvalidBookException {
        if (title == null || title.isBlank()) {
            throw new InvalidBookException("Titolo non valido");
        } else if (pages < 0) {
            throw new InvalidBookException("Le pagine devono essere > 0");
        } else if (author == null || author.isBlank()) {
            throw new InvalidBookException("Autore non valido");
        } else if (publisher == null || publisher.isBlank()) {
            throw new InvalidBookException("Editore non valido");
        } else {
            this.title = title;
            this.pages = pages;
            this.author = author;
            this.publisher = publisher;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new InvalidBookException("Titolo non valido");
        }
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages < 0) {
            throw new IllegalArgumentException();
        }
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new InvalidBookException("Autore non valido");
        }
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (publisher == null || publisher.isBlank()) {
            throw new InvalidBookException("Editore non valido");
        }
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book:" + '\n' +
                "title:" + title + '\n' +
                "pages:" + pages + '\n' +
                "author:" + author + '\n' +
                "publisher:" + publisher + '\n';
    }
}
