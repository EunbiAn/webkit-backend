package com.comstudy.todolist.service;

import java.util.List;
import java.util.Optional;

import com.comstudy.todolist.domain.TodoEntity;
import com.comstudy.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public void validate(final TodoEntity entity) {
        if(entity == null) {
            log.warn("entity가 null입니다.");
            throw new RuntimeException("entity가 null입니다.");
        }
        if(entity.getUserId() == null) {
            log.warn("userId가 없습니다!");
            throw new RuntimeException("userId가 없습니다!");
        }
    }

    // 매개 변수로 사용된 entity참조 변수를 이용해서 원본이 바뀌지 않도록 final 선언
    public List<TodoEntity> create(final TodoEntity entity) {
        // 유효성 검사 (null 체크) 필수!
        validate(entity);
        repository.save(entity);
        // 처리 후 로그 출력
        log.info("Entity id: {} is saved.", entity.getNo());
        return repository.findByUserId(entity.getUserId());
    }

    // 검색
    public List<TodoEntity> retrieve(final String userId){
        return repository.findByUserId(userId==null?"":userId);
    }

    // 수정
    public List<TodoEntity> update(final TodoEntity entity){
        validate(entity);
        // 검색
        final Optional<TodoEntity> original = repository.findById(entity.getNo());

        original.ifPresent(todo->{
            // 수정
            todo.setTitle(entity.getTitle());
            todo.setDone(entity.isDone());

            // 다시 저장
            repository.save(todo);
        });

        return retrieve(entity.getUserId());
    }

    // 삭제
    public List<TodoEntity> delete(final TodoEntity entity){
        validate(entity);
        try{
            repository.delete(entity);
        } catch (Exception e){
            log.warn(entity.getTitle()+ " => 삭제 안됨 ㅠㅠ");
        }
        return retrieve(entity.getUserId());
    }

    public String testService() {
        TodoEntity todoEntity = TodoEntity.builder().title("저녁 먹고 스터디 하기").build();
        repository.save(todoEntity);
        System.out.println();
        log.info(todoEntity.getNo());
        TodoEntity savedEntity = repository.findById(todoEntity.getNo()).get();
        return savedEntity.toString();
    }

    public List<TodoEntity> findAll() {
        return repository.findAll();
    }

    public Optional<TodoEntity> findById(String id) {
        return repository.findById(id);
    }
}