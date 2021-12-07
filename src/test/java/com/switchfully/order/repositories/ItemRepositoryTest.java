package com.switchfully.order.repositories;

import com.switchfully.order.domain.Item;
import com.switchfully.order.exceptions.ItemNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

    @Nested
    @DisplayName("find by id")
    class FindById {
        @Test
        @DisplayName("wrong id")
        void whenWrongId_thenThrowNewItemNotFoundException() {
            assertThatThrownBy(() -> defaultItemRepository.findById("test"))
                    .isInstanceOf(ItemNotFoundException.class)
                    .hasMessage("Item not found");
        }

        @Test
        @DisplayName("Correct id")
        void whenCorrectId_thenReturnItem1() {
            defaultItemRepository.saveItem(item1);
            String id = item1.getId();
            assertThat(defaultItemRepository.findById(id)).isEqualTo(item1);
        }
    }
}