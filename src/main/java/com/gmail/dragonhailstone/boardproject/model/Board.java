package com.gmail.dragonhailstone.boardproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Board {

    // Getter와 Setter
    @Id // 기본키를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동 생성
    private Long id; // 기본키 필드 (Long 타입)

    private String title;
    private String content;

    // 기본 생성자
    public Board() {}

    // 매개변수가 있는 생성자
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

}