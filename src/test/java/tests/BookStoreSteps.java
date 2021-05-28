package tests;

import endpoints.ApiEndpoint;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Book;
import models.BookStore;
import spec.Specs;

import java.util.List;

public class BookStoreSteps {

    @Step("Get response with all books from the book store")
    public Response getResponseWithBooks() {
        return RestAssured.given(Specs.request)
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
        return RestAssured.given(Specs.request)
                .when()
                .get(ApiEndpoint.BOOK.getPath(), isbn)
                .then()
                .spec(Specs.responseSpec)
                .log().body()
                .extract().as(Book.class);
    }
}
