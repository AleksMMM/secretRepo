package apiFootball.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseApiConfig {

    public static RequestSpecification testBase_requestSpec;
    public static ResponseSpecification testBase_responseSpec;

    @BeforeAll
    public static void setup() {
        testBase_requestSpec = new RequestSpecBuilder()
                .setBaseUri("http://users.bugred.ru")
                .setBasePath("/tasks/rest")
                .setContentType(ContentType.JSON)
                .build();

        testBase_responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        RestAssured.requestSpecification = testBase_requestSpec;
        RestAssured.responseSpecification = testBase_responseSpec;
    }
}
