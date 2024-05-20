package com.example.post.domain.dto;

import com.example.post.domain.Item;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public static PostResponseDto of(Item item) {
        return PostResponseDto
                .builder()
                .id(item.getId())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .username(item.getUsername())
                .build();
    }
}
