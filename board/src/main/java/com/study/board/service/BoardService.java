package com.study.board.service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;    // 객체 생성 - 의존성 주입..

    public void write(Board board){
        boardRepository.save(board);
    }

    public List<Board> boardlist(){
        return boardRepository.findAll();   // Board라는 class가 담긴 list를 찾아 반환
    }

    public Board boardview(Integer id){
        return boardRepository.findById(id).get();
    }

    public void boardDelete(Integer id){
        boardRepository.deleteById(id);

    }


}
