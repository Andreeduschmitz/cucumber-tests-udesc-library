package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookDAO {

    public static Path DEFAULT_PATH = Paths.get("src/main/resources/books.csv");
    private List<Book> library = new ArrayList<>();

    public void loadLibrary(Path path) {
        this.library = Utils.loadLibrary(path);
    }

    public void addBook(Book book) {
        this.library.add(book);
    }

    public boolean deleteBook(Book book) {
        return this.library.remove(book);
    }

    public int countBooksAmount() {
        return library.size();
    }

    public Book searchBookByTitle(String title) {
        for(Book book : library) {
            if(title.equals(book.getTitle())) {
                return book;
            }
        }
        return null;
    }

    public List<Book> listAllBooks() {
        return library;
    }

    public Map<Genre, Long> countQuantityByGenre() {
        return library.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));
    }

    public void updateLibrary(Path path) {
        List<String> csvLines = library.stream()
                .map(this::formatBookToCSV)
                .collect(Collectors.toList());

        try {
            Files.write(path, csvLines);
            System.out.println("Biblioteca atualizada com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo da biblioteca: " + e.getMessage());
        }
    }

    private String formatBookToCSV(Book book) {
        String authors = String.join(", ", book.getAuthors());
        return String.format("%s,%d,%s,%d,%s",
                book.getTitle(),
                book.getNumberOfPages(),
                book.getGenre(),
                book.getPublicationDate().getValue(),
                authors);
    }
}
