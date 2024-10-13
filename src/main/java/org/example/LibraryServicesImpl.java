package org.example;

import java.util.Map;

public class LibraryServicesImpl implements LibraryService{
    private BookDAO dao;

    public LibraryServicesImpl(boolean loadLibrary) {
        this.dao = new BookDAO();
        if (loadLibrary) {
            this.dao.loadLibrary(BookDAO.DEFAULT_PATH);
        }
    }

    @Override
    public void addBook(Book book) {
        this.dao.addBook(book);
        this.dao.updateLibrary(BookDAO.DEFAULT_PATH);
    }

    @Override
    public int countBooksQuantity() {
        return this.dao.countBooksAmount();
    }

    @Override
    public Book searchBookByTitle(String title) {
        return this.dao.searchBookByTitle(title);
    }

    @Override
    public Map<Genre, Long> countQuantityByGenre() {
        return this.dao.countQuantityByGenre();
    }
}
