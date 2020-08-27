package me.ljseokd.springboot.web.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloResponseDtoTest {
    @Test
    void lombokTest() {
        //given
         String name = "test";
         int amount = 1000;
        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertEquals(name, dto.getName());
        assertEquals(amount, dto.getAmount());
    }

}