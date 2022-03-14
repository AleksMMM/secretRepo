package api.streamApi;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class TestStreamApiConfig {

    public static RequestSpecification testBase_requestSpec;
    public static ResponseSpecification testBase_responseSpec;

    @BeforeAll
    public static void setup() {
        testBase_requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.kucoin.com")
                .setBasePath("/api/v1")
                .setContentType(ContentType.JSON)
                .build();

        testBase_responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

        RestAssured.requestSpecification = testBase_requestSpec;
        RestAssured.responseSpecification = testBase_responseSpec;
    }
}
