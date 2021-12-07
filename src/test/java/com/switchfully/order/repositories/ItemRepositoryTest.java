package com.switchfully.order.repositories;

import com.switchfully.order.domain.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    private DefaultItemRepository defaultItemRepository;
    private Item item1;


    @BeforeEach
    void setUp() {
        defaultItemRepository = new DefaultItemRepository();
        item1 = new Item("name", "description", 10, 100);
    }

    @Nested
    @DisplayName("Save item")
    class SaveItem {
        @Test
        @DisplayName("Save item")
        void whenSaveItem_thenReturnItem() {
            assertThat(defaultItemRepository.saveItem(item1)).isEqualTo(item1);
        }
    }
}