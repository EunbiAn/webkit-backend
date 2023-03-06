package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
//    @GetMapping("/")    // localhost:8080/ 주소에 매핑
//    @ResponseBody   // 해당 페이지에 아래 내용을 출력
    @GetMapping("/board/wite")  //  localhost:8080/board/write
    public String boardwriteForm(){
        return "boardwrite"; //boardwrite.html을 return
    }

    @PostMapping("/board/writedo")
    public String boardWritePost(Board board, Model model){
        boardService.write(board);

        model.addAttribute("message","글 작성이 완료 되었습니다");
        model.addAttribute("searchUrl", "/board/list");
        return "message";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){   // 데이터를 담아 페이지로 보내기 위해 Model 자료형을 인자로
        model.addAttribute("list",boardService.boardlist());    // boardService에서 생성한 boardlist 메소드를 통해 해당 list를  list라는 이름으로 넘겨주겠음
        return "boardlist";
    }

    @GetMapping("/board/view")
    public String bardview(Model model, Integer id){    // localhost:8080/board/view?id=1
        model.addAttribute("board", boardService.boardview(id));
        return "boardview";
    }

    @GetMapping("/board/delete")
    public String boardDelete(Integer id){
        boardService.boardDelete(id);
        return "redirect:/board/list";
    }

    @GetMapping("board/modify/{id}")    // id 는 path variable(주소 변수, 경로 변수)
    public String boardModify(@PathVariable("id") Integer id, Model model){
        model.addAttribute("board", boardService.boardview(id));
        return "boardModify";
    }

    @PostMapping("board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id,Board board, Model model){
        Board tmp = boardService.boardview(id);
        tmp.setTitle(board.getTitle());
        tmp.setContent(board.getContent());
        boardService.write(tmp);

        model.addAttribute("message","글이 수정 되었습니다");
        model.addAttribute("searchUrl", "/board/list");
        return "message";
    }

}
