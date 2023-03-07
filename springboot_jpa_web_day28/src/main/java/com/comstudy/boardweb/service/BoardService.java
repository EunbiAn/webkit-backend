package com.comstudy.boardweb.service;

import com.comstudy.boardweb.domain.Board;
import com.comstudy.boardweb.persistence.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void persist(Board board){
        boardRepository.save(board);
    }
    public List<Board> selectAll(){
        return (List<Board>) boardRepository.findAll();
    }
}
