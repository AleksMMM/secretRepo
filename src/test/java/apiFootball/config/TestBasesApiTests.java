package apiFootball.config;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pojoClases.CreateCompany;
import pojoClases.CreateUser;
import pojoClases.CreateUserPojo;

import static io.restassured.RestAssured.given;
import static java.util.Arrays.asList;

public class TestBasesApiTests extends TestBaseApiConfig {
    Faker faker = new Faker();

    CreateUser createUser = CreateUser.builder()
            .email(faker.internet().emailAddress())
            .name(faker.name().firstName())
            .tasks(asList(1, 2, 3))
            .companies(asList(4, 5, 6))
            .build();

    @Test
    public void createCompany() {
      CreateCompany createCompany = new CreateCompany();

              createCompany.setCompany_name("one");
              createCompany.setCompany_type("ooo");
              createCompany.setCompany_users(asList("test_anna22@gmail.com", "mrak2022@list.ru"));
              createCompany.setEmail_owner("ownerTest22@mail.com");

              Response response = given().log().all()
                      .body(createCompany)
                      .when()
                      .post("/createcompany")
                      .then()
                      .log().all()
                      .extract().response().jsonPath().get();

              int a = 0;
    }

    @Test
    public void createUsers() {
        CreateUserPojo userPojo = CreateUserPojo.builder()
                .email("ownerTest22@mail.com")
                .name("Aleks22")
                .password("12345678")
                .build();

        given()
                .body(userPojo)
        .when()
                .post("/doregister")

        .then()
                .log().all();
    }

    @Test
    public void createUserTest() {
      Response response = given()
                .body(createUser)
                     .log().all()
                .when()
                    .post("/createuser")
                .then()
                      .log()
                     .all()
              .extract().response().jsonPath().get();

      int a = 0;

    }
}
