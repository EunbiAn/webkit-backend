package com.comstudy.sarampjothy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        // 타임리프를 사용하면 src/main/resource의 템플릿이 뷰 기본 폴더
        return "index";
    }
}
