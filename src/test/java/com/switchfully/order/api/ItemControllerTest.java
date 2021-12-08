package com.switchfully.order.api;

import com.switchfully.order.domain.items.dto.CreateItemDTO;
import com.switchfully.order.domain.items.dto.ItemDTO;
import com.switchfully.order.domain.users.Address;
import com.switchfully.order.domain.users.TelephoneNumber;
import com.switchfully.order.domain.users.User;
import com.switchfully.order.domain.valueobjects.Currency;
import com.switchfully.order.domain.valueobjects.Price;
import com.switchfully.order.repositories.ItemRepository;
import com.switchfully.order.repositories.UserRepository;
import com.switchfully.order.security.Role;
import com.switchfully.order.services.ItemService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
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

//(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Disabled
class ItemControllerTest {

    //    @LocalServerPort
    @Value("${server.port}")
    private int port;

    private final ItemService itemService;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Autowired
    ItemControllerTest(ItemService itemService, ItemRepository itemRepository, UserRepository userRepository) {
        this.itemService = itemService;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
    }

    @BeforeAll
    void beforeAll() {
        TelephoneNumber telephoneNumber = new TelephoneNumber("03", "1234567");
        Address address = new Address(
                "streetName",
                "streetNumber",
                "postalCode",
                "city");
        User admin = new User(
                "firstName",
                "lastName",
                "email@email.email",
                address,
                telephoneNumber,
                Role.ADMIN,
                "username",
                "password");

        userRepository.saveUser(admin);
    }

    @Test
    void saveItemTest() {
        CreateItemDTO createItemDTO = new CreateItemDTO(
                "name",
                "description",
                10,
                100);

        System.out.println(port);

        ItemDTO itemDTO = RestAssured
                .given()
                .body(createItemDTO)
                .accept(JSON)
                .contentType(JSON)
                .header("authorization", generateBase64Authorization("email@email.email", "password"))
                .when()
                .port(port)
                .post("items")
                .then()
                .assertThat()
                .statusCode(400)
                .extract()
                .as(ItemDTO.class);

        assertThat(itemDTO.getAmount()).isEqualTo(100);
        assertThat(itemDTO.getDescription()).isEqualTo("description");
        assertThat(itemDTO.getName()).isEqualTo("name");
        assertThat(itemDTO.getPrice()).isEqualTo(new Price(10, Currency.EUR));
    }

    private String generateBase64Authorization(String email, String password) {
        return "Basic " + Base64.getEncoder().encodeToString((email + ":" + password).getBytes(StandardCharsets.UTF_8));
    }

}