package com.comstudy.todolist.controller;

import com.comstudy.todolist.dto.ResponseDTO;
import com.comstudy.todolist.dto.TestRequestBodyDTO;
import com.comstudy.todolist.service.TodoService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    TodoService todoService;
    @GetMapping("/todo/test")
    public String todoTest(){
        return todoService.testService();
    }

    @GetMapping("/")
    public String home(){
        // @RestController를 사용하면
        // 리턴되는 문자열이 브라우저에 바로 출력 된다.
        return "{\"message\":\"hello..\"}";
    }

    @PostMapping("/hello")
    public String postHello(@RequestParam("user")String user, @RequestParam("message")String message){
        return String.format("{\"user\":\"%s\",\"message\":\"%s\"}", user, message);
    }


    @GetMapping("/saram/{id}/{message}")
    public String pathVariables(
            @PathVariable(required = true) String id,
            @PathVariable String message) {
        // JSONObject 라이브러리 활용;
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("no", 1);
        jsonObj.put("id", id);
        jsonObj.put("message", message);
        return jsonObj.toString();
    }


    @GetMapping("/requestBody")
    public String testRequestBody(@RequestBody TestRequestBodyDTO reqDTO) {
        return reqDTO.toString();
    }

    @GetMapping("/requestBody2")
    public TestRequestBodyDTO testRequestBody2(@RequestBody TestRequestBodyDTO reqDTO) {
        return reqDTO;
    }

    @GetMapping("/responseBody")
    public ResponseDTO<String> responseBody(){
        List<String> list = new ArrayList<>();
        list.add("Hello SpringBoot world..");
        ResponseDTO<String> response = ResponseDTO.<String>builder().error("200").data(list).build();
        return response;
    }

    @GetMapping("/responseEntity")
    public ResponseEntity<?> responseEntity() {
        List<String> list = new ArrayList<String>();
        list.add("Hello World! I'm ResponseEntity. And you got 200!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // http status 400
        // return ResponseEntity.badRequest().body(response);
        // http status 200
        return ResponseEntity.ok().body(response);
    }


}
