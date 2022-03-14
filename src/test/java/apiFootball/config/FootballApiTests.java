package apiFootball.config;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.http.Header;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class FootballApiTests extends FootballApiConfig {

    @Test
    public void getDetailOfOneAreaTest() {

        given()
                .queryParam("areas", 2072)
        .when()
               .get("areas")
        .then()
                .log().all();
    }

    @Test
    public void getDateFounded() {
        given()
               // .basePath("/v1/")
                .log().all()
        .when()
                .get("teams/86")
        .then()
                .body("founded", equalTo(1902))
                .log().all();
    }

    @Test
    public void getFirstTeamName() {
        given()
        .when()
                .get("competitions/2021/teams")
                .then()
                .body("teams.name[0]", equalTo("Arsenal FC"))
                .log().all();
    }

    @Test
    public void getAllTeamData() {
        Response response =
                get("teams/86")
              .then()
                        .contentType(ContentType.JSON)
                        .extract().response();

        Headers header = response.getHeaders();


        int a = 0;
    }

    @Test
    public void extractFirstTeamName() {
        String firstName =
                given()
                        .when()
                        .get("competitions/2021/teams")
                        .jsonPath().getString("teams.name[0]");

        System.out.println(firstName);
    }

    @Test
    @DisplayName("Получение списка всех команд с помощью jsonpath")
    public void extractTeamsNames() {
        Response response =
                given()
                        .when()
                        .get("competitions/2021/teams")
                        .then()
                        .extract()
                        .response();
        List<String> teamName = response.path("teams.name");
        teamName.forEach(System.out::println);
    }


}
