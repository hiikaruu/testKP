package steps;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import models.*;
import org.testng.Assert;


import static io.restassured.RestAssured.given;

public class TestSteps {
    @Step("Проверка неизвестного пользователя")
    public void checkUser(UserNFResponse userExcepted, UserNFResponse userActual){
        Assert.assertEquals(userExcepted, userActual);
    }
    @Step("Проверка питомца")
    public void checkResponse(PetResponse petExcepted, PetResponse petActual){
        Assert.assertEquals(petActual, petExcepted);
    }
    @Step("Проверка заказа")
    public void checkOrder(OrderResponse orderExcepted, OrderResponse orderActual){
        Assert.assertEquals(orderExcepted, orderActual);
    }
    @Step("Создать пользователя")
    public PetResponse createPet(PetRequest PR, Integer statusCode) {
        return given()
                .baseUri("https://petstore.swagger.io/")
                .body(PR)
                .contentType(ContentType.JSON)
                .post("/v2/pet")
                .then()
                .statusCode(statusCode)
                .extract()
                .response().body().as(PetResponse.class);
    }
    @Step("Получить питомца по Id")
    public PetResponse getPetById(Integer statusCode) {
        return given()
                .baseUri("https://petstore.swagger.io/")
                .get("/v2/pet/10")
                .then()
                .statusCode(statusCode)
                .extract()
                .response().body().as(PetResponse.class);
    }
    @Step ("Получить пользователя по Username")
    public UserNFResponse getNFUser( Integer statusCode) {
        return given()
                .baseUri("https://petstore.swagger.io/")
                .get("/v2/user/hikaru")
                .then()
                .statusCode(statusCode)
                .extract()
                .response().body().as(UserNFResponse.class);}
    @Step("Получить заказ по Id")
    public OrderResponse getOrder(Integer statusCode) {
        return given()
                .baseUri("https://petstore.swagger.io/")
                .get("/v2/store/order/4")
                .then()
                .statusCode(statusCode)
                .extract()
                .response().body().as(OrderResponse.class);
    }

}

