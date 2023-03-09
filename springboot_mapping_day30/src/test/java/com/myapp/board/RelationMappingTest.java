package com.myapp.board;

import com.myapp.board.entity.Board;
import com.myapp.board.entity.Member;
import com.myapp.board.persistence.BoardRepository;
import com.myapp.board.persistence.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
public class RelationMappingTest {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void manyToOneInsert(){
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
    }

    @Test
    public void manyToOneSelect(){
        Board board = boardRepository.findById(3).get();

        System.out.println("[ "+board.getSeq()+" 번 게시물 정보 ]");
        System.out.println("제목 : "+ board.getTitle());
        System.out.println("내용 : "+ board.getContent());
        System.out.println("작성자 : "+ board.getMember().getName());
        System.out.println("작성자 권한 : "+ board.getMember().getRole());

    }

    @Test
    public void oneToManyTest(){
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


    }

}
