package com.gmail.dragonhailstone.boardproject;

import com.gmail.dragonhailstone.boardproject.model.Board;
import com.gmail.dragonhailstone.boardproject.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest  // JPA 관련 테스트만 실행, 실제 DB에 연결하여 테스트합니다.
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testSaveBoard() {
        // Given
        Board board = new Board("Test Title", "Test Content");

        // When
        Board savedBoard = boardRepository.save(board);

        // Then
        assertThat(savedBoard).isNotNull();
        assertThat(savedBoard.getId()).isGreaterThan(0);
        assertThat(savedBoard.getTitle()).isEqualTo("Test Title");
    }

    @Test
    public void testFindAllBoards() {
        // Given
        boardRepository.save(new Board("Title 1", "Content 1"));
        boardRepository.save(new Board("Title 2", "Content 2"));

        // When
        long count = boardRepository.count();

        // Then
        assertThat(count).isGreaterThan(1);
    }
}
