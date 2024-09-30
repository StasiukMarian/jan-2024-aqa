package api.lesson9;

import base.pojos.createUser.CreateUserRequest;
import base.pojos.createUser.CreateUserResponse;
import base.pojos.getPets.Pet;
import base.pojos.getUser.GetUserData;
import base.pojos.updateUser.UpdateUserResponse;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static base.helpers.Constants.BASE_URL;
import static base.helpers.Specifications.*;
import static io.restassured.RestAssured.given;

public class PojoTest {

    //    @Test
    public void getUserData() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));
        List<GetUserData> userData = given()
                .when()
                .get("api/users?page=2")
                .then()
                .extract().body().jsonPath().getList("data", GetUserData.class);

        Assert.assertNotNull(userData);

        for (int i = 0; i < userData.size(); i++) {
            Assert.assertTrue(userData.get(i).getEmail().contains("@reqres.in"));
            Assert.assertTrue(userData.get(i).getAvatar().contains(userData.get(i).getId().toString()));
        }
    }

    //    @Test
    public void createUserTest() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(201));

        CreateUserRequest request = new CreateUserRequest();

        request.setName("morpheus");
        request.setJob("leader");

        CreateUserResponse response = given()
                .body(request)
                .when()
                .post("api/users")
                .then()
                .log().body().extract().as(CreateUserResponse.class);

        Assert.assertNotNull(response);

        Assert.assertEquals(request.getName(), response.getName());
        Assert.assertEquals(request.getJob(), response.getJob());
    }

//    @Test
    public void updateUser() {
        getSpecifications(requestSpecification(BASE_URL), responseSpecification(200));

        CreateUserRequest requestUpdate = new CreateUserRequest("morpheus", "leader");

        UpdateUserResponse updateUserResponse = given()
                .body(requestUpdate)
                .when()
                .put("api/users/2")
                .then()
                .extract().as(UpdateUserResponse.class);

        Assert.assertEquals(requestUpdate.getName(), updateUserResponse.getName());
        Assert.assertEquals(requestUpdate.getJob(), updateUserResponse.getJob());

    }
    @Test
    public void getAvailablePets(){

        Pet[] pets = given()
                .when()
                .accept(ContentType.JSON)
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
                .then()
                .statusCode(200)
                .log().body()
                .extract().as(Pet[].class);

        List<Pet> petList = Arrays.asList(pets);

        for (Pet pet : petList) {
            Assert.assertEquals(pet.getStatus(), "available");
        }
    }
}
