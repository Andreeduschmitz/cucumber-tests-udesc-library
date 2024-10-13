package org.example;

import java.time.Year;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private Integer numberOfPages;
    private Genre genre;
    private Year publicationDate;
    private List<String> authors;

    public Book(String title, Integer numberOfPages, Genre genre, Year publicationDate, String... authors) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.publicationDate = publicationDate;
        this.authors = Arrays.asList(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Year getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Year publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Título: ").append(title).append("\n")
                .append("Autores: ").append(authors.isEmpty() ? "Desconhecido" : String.join(", ", authors)).append("\n")
                .append("Gênero: ").append(genre).append("\n")
                .append("Páginas: ").append(numberOfPages).append("\n")
                .append("Publicado em: ").append(publicationDate).append("\n");

        return stringBuilder.toString();
    }
}