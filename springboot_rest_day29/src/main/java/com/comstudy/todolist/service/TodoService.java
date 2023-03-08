package com.comstudy.todolist.service;

import com.comstudy.todolist.domain.TodoEntity;
import com.comstudy.todolist.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public String testService(){
        TodoEntity todoEntity = TodoEntity.builder().title("저녁먹고 잠 자기").build();
        todoRepository.save(todoEntity);
        log.info(todoEntity.getId());
        TodoEntity savedEntity = todoRepository.findById(todoEntity.getId()).get();
        System.out.println(savedEntity);
        return savedEntity.toString();
    }

    public Optional<TodoEntity> findById(String id){
        return todoRepository.findById(id);
    }
}
