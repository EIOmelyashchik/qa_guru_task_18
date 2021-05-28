package spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import restassured.LogFilter;
import tests.TestData;

import static io.restassured.RestAssured.with;

public class Specs {
    public static RequestSpecification request = with()
            .filter(LogFilter.filters().withCustomTemplates())
            .baseUri(TestData.getApiUrl())
            .basePath("/BookStore/v1")
            .log().uri()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
