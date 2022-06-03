package com.example.demogame.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository){
        this.boardRepository= boardRepository;
    }
    public List<Board> getAllBoards (){
        return boardRepository.findAll();
    }

//    public void insertBoard(){
//        boardRepository
//    }
}
