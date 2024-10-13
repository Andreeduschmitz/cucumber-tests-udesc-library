package org.example;

import java.util.List;
import java.util.Map;

public interface LibraryService {

    public void addBook(Book book);

    public int countBooksQuantity();

    public Book searchBookByTitle(String title);

    public Map<Genre, Long> countQuantityByGenre();
}
