package com.example.library;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.pt.*;
import org.example.Book;
import org.example.Genre;
import org.example.LibraryService;
import org.example.LibraryServicesImpl;
import org.junit.Assert;

import java.time.Year;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.*;

public class StepsDefs {

    private Book book;
    private LibraryService libraryService;
    private Map<Genre, Long> booksPerGenre;

    @Dado("a inicialização da biblioteca")
    public void aInicializaçãoDaBiblioteca() {
        this.libraryService = new LibraryServicesImpl(true);
    }

    @E("ela possui mais de {int} livros")
    public void elaPossuiMaisDeLivros(int arg0) {
        assertNotEquals(this.libraryService.countBooksQuantity(), arg0);
    }

    @Quando("Eu pesquiso o livro {string}")
    public void euPesquisoOLivro(String arg0) {
        this.book = this.libraryService.searchBookByTitle(arg0);
    }

    @Entao("eu encontro o livro")
    public void euEncontroOLivro() {
        Assert.assertNotNull(this.book);
    }

    @Quando("eu conto a quantidade de livros por genero")
    public void euContoAQuantidadeDeLivrosPorGenero() {
        this.booksPerGenre = this.libraryService.countQuantityByGenre();
    }

    @Entao("eu tenho {int} livros de {}")
    public void euTenhoLivrosDeGenero(int quantidade, Genre genero) {
        assertEquals((long) this.booksPerGenre.get(genero), quantidade);
    }

    @E("eu nao encontro nenhum outro genero")
    public void euNaoEncontroNenhumOutroGenero() {
        for (Genre genero : this.booksPerGenre.keySet()) {
            if (!genero.equals(Genre.ROMANCE) && !genero.equals(Genre.DRAMA) && !genero.equals(Genre.FICTION)) {
                Assert.fail("Encontrado um gênero inesperado: " + genero);
            }
        }
    }

    @Dado("a seguinte tabela de livros a serem adicionados:")
    public void aSeguinteTabelaDeLivros(List<Book> livros) {
        livros.forEach( book -> this.libraryService.addBook(book));
    }

    @DataTableType
    public Book converterDeLivro(Map<String, String> entrada) {
        return new Book(
                entrada.get("title"),
                Integer.parseInt(entrada.get("numberOfPages").trim()),
                Genre.valueOf(entrada.get("genre").trim()),
                Year.parse(entrada.get("publicationDate").trim()),
                entrada.get("authors")
        );
    }
}
