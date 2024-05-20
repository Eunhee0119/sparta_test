package com.example.post.domain.dto;

import com.example.post.domain.Item;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostSummaryResponseDto {
    private Long id;
    private String title;
    private int price;
    private String username;

    public static PostSummaryResponseDto of(Item item) {
        return PostSummaryResponseDto
                .builder()
                .id(item.getId())
                .title(item.getTitle())
                .price(item.getPrice())
                .username(item.getUsername())
                .build();
    }
}
