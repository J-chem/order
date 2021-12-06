package com.switchfully.order.api;

import com.switchfully.order.domain.Address;
import com.switchfully.order.domain.TelephoneNumber;
import com.switchfully.order.security.Role;
import com.switchfully.order.services.dto.CreateUserDTO;
import com.switchfully.order.services.dto.UserDTO;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    private CreateUserDTO createUserDTO;
    private Address address;
    private TelephoneNumber telephoneNumber;

    @BeforeEach
    void beforeEach() {
        telephoneNumber = new TelephoneNumber("03", "1234567");
        address = new Address("streetName", "streetNumber", "postalCode", "city");
        createUserDTO = new CreateUserDTO("firstName", "lastName", address, "email@email.email", telephoneNumber, Role.CUSTOMER);
    }

    @Test
    void saveBookTest() {
        UserDTO userDTO = RestAssured
                .given()
                .body(createUserDTO)
                .accept(JSON)
                .contentType(JSON)
                .when()
                .port(port)
                .post("/users/registerCustomer")
                .then()
                .assertThat()
                .statusCode(HttpStatus.CREATED.value())
                .extract()
                .as(UserDTO.class);

        assertThat(userDTO.getUserId()).isNotBlank();
        assertThat(userDTO.getFirstName()).isEqualTo("firstName");
        assertThat(userDTO.getLastName()).isEqualTo("lastName");
        assertThat(userDTO.getRole()).isEqualTo(Role.CUSTOMER);
    }
}