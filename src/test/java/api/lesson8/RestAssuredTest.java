package api.lesson8;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static base.helpers.Constants.BASE_URL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredTest {

    //    @Test
    public void getTest() {
//        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
//
//        System.out.println(response.asString());
//
//        int statusCode = response.statusCode();
//
//        Assert.assertEquals(statusCode, 200);

        given()
                .get(BASE_URL + "api/users?page=2")
                .then()
                .statusCode(200).log().body()
                .body("data.id[3]", equalTo(10));

        given()
                .get(BASE_URL + "api/users?page=2")
                .then()
                .statusCode(200).log().body()
                .body("total", equalTo(12));

        Response response = given()
                .accept(ContentType.JSON)
                .get(BASE_URL + "api/users?page=2")
                .then()
                .statusCode(200)
                .extract().response();

        Assert.assertEquals(response.jsonPath().getString("data.first_name[1]"), "Lindsay");
    }

//    @Test
    public void postTest() {
        Map<String, String> request = new HashMap<>();

        request.put("name", "Marian");
        request.put("job", "aqa");

        given()
                .accept(ContentType.JSON)
                .body(request)
                .when()
                .post(BASE_URL + "api/users")
                .then()
                .statusCode(201).log().body();
    }

//    @Test
    public void putTest(){
        Map<String, String> request = new HashMap<>();

        request.put("name", "Marian");
        request.put("job", "aqa");

        given()
                .accept(ContentType.JSON)
                .body(request)
                .when()
                .put(BASE_URL + "api/users/2")
                .then()
                .statusCode(200).log().all();
    }
    @Test
    public void deleteTest(){
        given()
                .delete(BASE_URL + "api/users/2")
                .then()
                .statusCode(204).log().all();
    }
}
