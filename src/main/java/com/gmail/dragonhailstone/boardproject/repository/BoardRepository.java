package com.gmail.dragonhailstone.boardproject.repository;

import com.gmail.dragonhailstone.boardproject.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // 기본 CRUD 메소드 제공
}