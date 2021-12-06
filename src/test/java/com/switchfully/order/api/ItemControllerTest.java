package com.switchfully.order.api;

import com.switchfully.order.domain.Address;
import com.switchfully.order.domain.TelephoneNumber;
import com.switchfully.order.domain.User;
import com.switchfully.order.repositories.DefaultUserRepository;
import com.switchfully.order.repositories.UserRepository;
import com.switchfully.order.security.Role;
import com.switchfully.order.services.dto.CreateItemDTO;
import com.switchfully.order.services.dto.ItemDTO;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerTest {

//    @LocalServerPort
//    private int port;
//
//    private CreateItemDTO createItemDTO;
//    private User admin;
//    private Address address;
//    private TelephoneNumber telephoneNumber;
//    private DefaultUserRepository userRepository;
//
//    @BeforeEach
//    void beforeEach() {
//        createItemDTO = new CreateItemDTO("name", "description", 10, 100);
//        telephoneNumber = new TelephoneNumber("03", "1234567");
//        address = new Address("streetName", "streetNumber", "postalCode", "city");
//        admin = new User("firstName", "lastName", "email@email.email", address,telephoneNumber, Role.ADMIN, "username", "password");
//        userRepository = new DefaultUserRepository();
//    }
//
//    @Test
//    void saveItemTest() {
//        ItemDTO itemDTO = RestAssured
//                .given()
//                .header("Authorization", generateBase64Authorization("email@email.email", "hardCodeAdmin"))
//                .body(createItemDTO)
//                .accept(JSON)
//                .contentType(JSON)
//                .when()
//                .port(port)
//                .post("/items/postItem")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.CREATED.value())
//                .extract()
//                .as(ItemDTO.class);
//
//        assertThat(itemDTO.getAmount()).isEqualTo(100);
//        assertThat(itemDTO.getDescription()).isEqualTo("description");
//        assertThat(itemDTO.getName()).isEqualTo("name");
//        assertThat(itemDTO.getPrice()).isEqualTo(BigDecimal.TEN);
//    }
//
//    private String generateBase64Authorization(String email, String password) {
//        return "Basic " + Base64.getEncoder().encodeToString((email + ":" + password).getBytes(StandardCharsets.UTF_8));
//    }

}