package com.example.post.domain.dto;

import com.example.post.domain.Item;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostRequestDto {
    private String title;
    private String content;
    private int price;
    private String username;

    public static Item toItems(PostRequestDto postRequestDto) {
        return Item.builder()
                .title(postRequestDto.title)
                .content(postRequestDto.content)
                .price(postRequestDto.price)
                .username(postRequestDto.username)
                .build();
    }
}
