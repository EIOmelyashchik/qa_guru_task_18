package tests;

import endpoints.ApiEndpoint;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.Book;
import models.BookStore;
import spec.Specs;

import java.util.List;

import static io.restassured.RestAssured.given;

public class BookStoreSteps {

    @Step("Get response with all books from the book store")
    public Response getResponseWithBooks() {
        return given(Specs.request)
                .when()
                .get(ApiEndpoint.BOOKS.getPath())
                .then()
                .spec(Specs.responseSpec)
                .log().body()
                .extract().response();
    }

    @Step("Get all books from the book store")
    public List<Book> getBooks() {
        return getResponseWithBooks()
                .then()
                .extract().as(BookStore.class)
                .getBooks();
    }

    @Step("Get book from the book store by isbn")
    public Book getBook(Long isbn) {
        return given(Specs.request)
                .when()
                .formParam("ISBN", isbn)
                .get(ApiEndpoint.BOOK.getPath())
                .then()
                .spec(Specs.responseSpec)
                .log().body()
                .extract().as(Book.class);
    }
}
