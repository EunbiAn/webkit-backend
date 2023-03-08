package com.comstudy.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder // 체인형식으로 데이터를 넣을 수 있다
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {
    private String error;
    private List<T> data;
}
