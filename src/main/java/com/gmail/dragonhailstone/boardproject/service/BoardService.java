package com.gmail.dragonhailstone.boardproject.service;

import com.gmail.dragonhailstone.boardproject.model.Board;
import com.gmail.dragonhailstone.boardproject.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board createBoard(Board board) {
        return boardRepository.save(board);  // 새로운 게시글을 데이터베이스에 저장
    }
}

