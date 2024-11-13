package com.gmail.dragonhailstone.boardproject.controller;

import com.gmail.dragonhailstone.boardproject.model.Board;
import com.gmail.dragonhailstone.boardproject.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/boards")  // /boards 경로로 요청을 처리
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // GET 요청 처리: 모든 게시글 조회
    @GetMapping
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    // POST 요청 처리: 새 게시글 추가
    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return boardService.createBoard(board);  // 서비스 계층에서 게시글 생성
    }
}