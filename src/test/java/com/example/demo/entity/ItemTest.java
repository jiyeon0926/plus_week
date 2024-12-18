package com.example.demo.entity;

import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @Test
    @DisplayName("status nullable = false 제약 조건 테스트")
    void isStatusNotNull() {
        // given
        User manager = new User("admin", "user1@naver.com", "유저1", "user*1234");
        User owner = new User("user", "user2@naver.com", "유저2", "user*1234");

        Item mockItem = new Item("연필", "필기구", manager, owner);
        mockItem.setStatus("PENDING");
        when(itemRepository.findItemByName("연필")).thenReturn(mockItem);

        // when
        Item foundItem = itemService.findItemByName("연필");

        // then
        assertThat(foundItem).isNotNull();
        assertThat(foundItem.getStatus()).isNotNull();
    }
}