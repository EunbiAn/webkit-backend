package com.comstudy.todolist.controller;

import com.comstudy.todolist.domain.TodoEntity;
import com.comstudy.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/todo/findByUserId")
    public String findByUserId(){
        String id = "4028659486c021ac0186c02210e40000";
        Optional<TodoEntity> todo =todoService.findById(id);
        System.out.println(todo);
        return String.valueOf(todo);
    }

}
