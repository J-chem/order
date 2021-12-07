package com.switchfully.order.api;

import com.switchfully.order.domain.Address;
import com.switchfully.order.domain.TelephoneNumber;
import com.switchfully.order.domain.User;
import com.switchfully.order.repositories.ItemRepository;
import com.switchfully.order.repositories.UserRepository;
import com.switchfully.order.security.Role;
import com.switchfully.order.services.ItemService;
import com.switchfully.order.services.dto.CreateItemDTO;
import com.switchfully.order.services.dto.ItemDTO;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @LocalServerPort
//    private int port;
//
//    private final ItemService itemService;
//    private final ItemRepository itemRepository;
//    private final UserRepository userRepository;
//
//    @Autowired
//    ItemControllerTest(ItemService itemService, ItemRepository itemRepository, UserRepository userRepository) {
//        this.itemService = itemService;
//        this.itemRepository = itemRepository;
//        this.userRepository = userRepository;
//    }
//
//    @BeforeAll
//    void beforeAll() {
//        TelephoneNumber telephoneNumber = new TelephoneNumber("03", "1234567");
//        Address address = new Address("streetName", "streetNumber", "postalCode", "city");
//        User admin = new User(
//                "firstName",
//                "lastName",
//                "email@email.email",
//                address,
//                telephoneNumber,
//                Role.ADMIN,
//                "username",
//                "password");
//
//        userRepository.saveUser(admin);
//    }
//
//    @Test
//    void saveItemTest() {
//        CreateItemDTO createItemDTO = new CreateItemDTO(
//                "name",
//                "description",
//                10,
//                100);
//
//        ItemDTO itemDTO = RestAssured
//                .given()
//                .body(createItemDTO)
//                .accept(JSON)
//                .contentType(JSON)
//                .header("authorization", generateBase64Authorization("email@email.email", "password"))
//                .when()
//                .port(port)
//                .post("/items")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.OK.value())
//                .extract()
//                .as(ItemDTO.class);
//
//        assertThat(itemDTO.getAmount()).isEqualTo(100);
//        assertThat(itemDTO.getDescription()).isEqualTo("description");
//        assertThat(itemDTO.getName()).isEqualTo("name");
//        assertThat(itemDTO.getPrice()).isEqualTo(10);
//    }
//
//    private String generateBase64Authorization(String email, String password) {
//        return "Basic " + Base64.getEncoder().encodeToString((email + ":" + password).getBytes(StandardCharsets.UTF_8));
//    }

}