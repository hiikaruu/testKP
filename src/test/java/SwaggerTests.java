import models.*;
import org.testng.annotations.Test;
import steps.TestSteps;

import java.util.ArrayList;
import java.util.Arrays;

import static steps.Steps.STEPS;

public class SwaggerTests {
    @Test(description = "Добавление нового питомца ")
    public void postCreate() {
        PetRequest petRequest = new PetRequest("Cat","available");
        PetResponse petResponse = STEPS.createPet(petRequest, 200);
        System.out.println(petResponse);
    }
    @Test(description = "Получение питомца по Id")
    public void getPetById() {
        PetResponse petEx = new PetResponse(10, new Category(10, "sample string"),"doggie", new ArrayList<>(Arrays.asList("sample 1","sample 2","sample 3")), new Tag[]{new Tag(10, "sample string")},"available");
        PetResponse pet = STEPS.getPetById( 200);
        STEPS.checkResponse(pet, petEx);
        System.out.println(pet);
    }
    @Test(description = "Поиск и получение пользователя по Username")
    public void getNFUserByUsername() {
        UserNFResponse userEx = new UserNFResponse(1,"error","User not found");
        UserNFResponse user = STEPS.getNFUser( 404);
        STEPS.checkUser(user, userEx);
        System.out.println(user);
    }
    @Test(description = "Поиск и получение заказа по Id")
    public void getOrderById() {
        OrderResponse orderEx = new OrderResponse(4,0,0, "2023-12-19T19:39:44.492+0000", "placed", true);
        OrderResponse order = STEPS.getOrder( 200);
        STEPS.checkOrder(order, orderEx);
        System.out.println(order);
    }

}
