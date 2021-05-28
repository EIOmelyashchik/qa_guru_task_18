package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import models.Book;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Verify Book Store")
public class BookStoreTests {
    private final BookStoreSteps steps = new BookStoreSteps();

    @Test
    @Owner("omelyashchik")
    @Feature("Api")
    @DisplayName("Verify book's iban")
    public void checkIban() {
        List<Book> books = steps.getBooks();

        Allure.step("Check that response contains at least one book", () ->
                assertThat(books.size()).as("Number of books").isGreaterThanOrEqualTo(1));

        Allure.step("Check that all books have a correct format of 'isbn'", () ->
                books.forEach(book -> {
                    Long isbn = book.getIsbn();
                    Allure.step(String.format("Check that book '%s' has a correct format of 'isbn: %s' (13 digits)",
                            book.getTitle(), isbn), () ->
                            assertThat(isbn).as("isbn").asString().matches("^\\d{13}$"));
                }));
    }

    @Test
    @Owner("omelyashchik")
    @Feature("Api")
    @DisplayName("Verify books")
    public void checkShoppingCartApi() {
        List<Book> books = steps.getBooks();

        Allure.step("Check that all books can get from Book Store by 'isbn' and the information matches", () ->
                books.forEach(expectedBook -> {
                    Long isbn = expectedBook.getIsbn();
                    Allure.step(String.format("Check the book with isbn '%d'", isbn), () -> {
                        Book actualBook = steps.getBook(isbn);
                        assertThat(actualBook).as("Book").isEqualTo(expectedBook);
                    });
                }));
    }
}
