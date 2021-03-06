package com.switchfully.order.api;

import com.switchfully.order.domain.users.Address;
import com.switchfully.order.domain.users.TelephoneNumber;
import com.switchfully.order.security.Role;
import com.switchfully.order.domain.users.dto.CreateUserDTO;
import com.switchfully.order.domain.users.dto.UserDTO;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;

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
        createUserDTO = new CreateUserDTO("firstName", "lastName", "email@email.email", address, telephoneNumber, Role.CUSTOMER, "username", "password");
    }

    @Test
    void saveUserTest() {
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