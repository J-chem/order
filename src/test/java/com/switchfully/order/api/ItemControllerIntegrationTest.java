package com.switchfully.order.api;

import com.switchfully.order.domain.items.dto.CreateItemDTO;
import com.switchfully.order.domain.items.dto.ItemDTO;
import com.switchfully.order.domain.valueobjects.Currency;
import com.switchfully.order.domain.valueobjects.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Profile("integration")
class ItemControllerIntegrationTest {

    @Autowired
    private ItemController itemController;

    @Test
    void whenSave_returnItemDTO() {
        CreateItemDTO createItemDTO = new CreateItemDTO("name", "desc", new Price(10, Currency.EUR), 20);
        ItemDTO result = itemController.saveItem(createItemDTO, generateBase64Authorization("username", "password"));

        assertThat(result.getName()).isEqualTo(createItemDTO.getName());
        assertThat(result.getDescription()).isEqualTo(createItemDTO.getDescription());
        assertThat(result.getPrice()).isEqualTo(createItemDTO.getPrice());
    }

    private String generateBase64Authorization(String username, String password) {
        return "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
    }
}