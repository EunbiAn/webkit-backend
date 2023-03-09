package com.comstudy.todolist.controller;

import com.comstudy.todolist.domain.TodoEntity;
import com.comstudy.todolist.dto.ResponseDTO;
import com.comstudy.todolist.dto.TodoDTO;
import com.comstudy.todolist.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    TodoService todoService;
    String tempUserId = "temporary-user";
    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto){

        try{
            // Entity로 변환
            TodoEntity entity = dto.toEntity();
            // Entity의 id는 생성 당시에 null이어야함(테이블 insert 시 자동 생성되도록 해놨기 때문,,)
            entity.setId(null); // 임시 null 처리,,
            // 임시 userId 사용
            entity.setUserId(tempUserId);
            // service를 이용해서 Entity List 생성
            List<TodoEntity> entities = todoService.create(entity);
            // TodoEntity 리스트를 DTO들로 변경
            List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
            // TodoDTO 리스트를 ResponseDTO로 초기화
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
            // ResponseDTO를 리턴
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            // 예외 발생 시 처리
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO
                    .<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    // 검색 기능
    @GetMapping
    public ResponseEntity<?> searchTodo(@RequestBody TodoDTO dto){
        List<TodoEntity> entities = todoService.retrieve(dto.getUserId());
        List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
        // TodoDTO 리스트를 ResponseDTO로 초기화
        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
        // ResponseDTO를 리턴
        return ResponseEntity.ok().body(response);
    }
    // 수정
    @PutMapping
    public ResponseEntity<?> updateTodo(@RequestBody TodoDTO dto){
        // Entity로 변환
        TodoEntity entity = dto.toEntity();
        // userId 초기화
        entity.setUserId(tempUserId);
        // 엔티티로 업데이트
        List<TodoEntity>  entities = todoService.update(entity);
        // 엔티티 리스트를 Todo 리스트로 변환
        List<TodoDTO> todos = entities.stream()
                .map(TodoDTO::new).collect(Collectors.toList());
        // ResponseDTO로 초기화
        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(todos).build();
        // ResponseDTO로 리턴
        return  ResponseEntity.ok().body(response);
    }
    // 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteTodo(@RequestBody TodoDTO dto) {
        try {
            // Entity로 변환
            TodoEntity entity = dto.toEntity();
            // userId 초기화
            entity.setUserId(tempUserId);
            // 엔티티로 업데이트
            List<TodoEntity> entities = todoService.delete(entity);
            // 엔티티 리스트를 Todo 리스트로 변환
            List<TodoDTO> todos = entities.stream()
                    .map(TodoDTO::new).collect(Collectors.toList());
            // ResponseDTO로 초기화
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(todos).build();
            // ResponseDTO로 리턴
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            ResponseDTO<TodoEntity> response = ResponseDTO
                    .<TodoEntity>builder().error("삭제 에러!").build();
            return ResponseEntity.ok().body(response);
        }
    }

}
