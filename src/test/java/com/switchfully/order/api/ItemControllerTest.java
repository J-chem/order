package com.switchfully.order.api;

import com.switchfully.order.domain.items.dto.CreateItemDTO;
import com.switchfully.order.domain.items.dto.ItemDTO;
import com.switchfully.order.domain.users.Address;
import com.switchfully.order.domain.users.TelephoneNumber;
import com.switchfully.order.domain.users.User;
import com.switchfully.order.domain.users.dto.CreateUserDTO;
import com.switchfully.order.domain.valueobjects.Currency;
import com.switchfully.order.domain.valueobjects.Price;
import com.switchfully.order.repositories.ItemRepository;
import com.switchfully.order.repositories.UserRepository;
import com.switchfully.order.security.Role;
import com.switchfully.order.services.ItemService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ItemControllerTest {

    @LocalServerPort
    private int port;

    private final ItemService itemService;
    private final ItemRepository itemRepository;
    private final UserController userController;

    @Autowired
    ItemControllerTest(ItemService itemService, ItemRepository itemRepository, UserController userController) {
        this.itemService = itemService;
        this.itemRepository = itemRepository;
        this.userController = userController;
    }

    @Test
    void saveItemTest() {
        TelephoneNumber telephoneNumber = new TelephoneNumber("03", "1234567");
        Address address = new Address(
                "streetName",
                "streetNumber",
                "postalCode",
                "city");
        CreateUserDTO admin = new CreateUserDTO(
                "firstName",
                "lastName",
                "email@email.email",
                address,
                telephoneNumber,
                Role.ADMIN,
                "username",
                "password");

        userController.registerCustomer(admin);

        CreateItemDTO createItemDTO = new CreateItemDTO(
                "name",
                "description",
                new Price(10, Currency.EUR),
                100);

        ItemDTO itemDTO = RestAssured
                .given()
                .body(createItemDTO)
                .accept(JSON)
                .contentType(JSON)
                .header("authorization", generateBase64Authorization("username", "password"))
                .when()
                .port(port)
                .post("items")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(ItemDTO.class);

        assertThat(itemDTO.getStock()).isEqualTo(100);
        assertThat(itemDTO.getDescription()).isEqualTo("description");
        assertThat(itemDTO.getName()).isEqualTo("name");
        assertThat(itemDTO.getPrice()).isEqualTo(new Price(10, Currency.EUR));
    }

    private String generateBase64Authorization(String username, String password) {
        return "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
    }

}