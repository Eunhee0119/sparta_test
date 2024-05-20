package com.example.post.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
public class Item {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    @Builder
    public Item(String title, String content, int price, String username) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.username = username;
    }

    public void changeTitle(String title) {
        this.title = title;
    }
    public void changeContent(String content) {
        this.content = content;
    }
    public void changePrice(int price) {
        this.price = price;
    }
    public void changeUsername(String username) {
        this.username = username;
    }
}
