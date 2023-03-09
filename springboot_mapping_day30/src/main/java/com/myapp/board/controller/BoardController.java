package com.myapp.board.controller;

import com.myapp.board.entity.Board;
import com.myapp.board.entity.Member;
import com.myapp.board.persistence.BoardRepository;
import com.myapp.board.persistence.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class BoardController {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/board/test")
    public String boardTest(){
        Member member = new Member();
        member.setId("member1");
        member.setName("나다");
        member.setPassword("1212");
        member.setRole("User");

        memberRepository.save(member);

        for(int i = 1; i <=3; i++){
            Board board = new Board();
            board.setMember(member);
            board.setTitle("게시글제목"+i);
            board.setContent("게시글 내용입니다"+i);
            board.setCreateDate(new Date());
            board.setCnt(0);
            boardRepository.save(board);
        }
        return  "boardTest() 호출~";
    }

}
