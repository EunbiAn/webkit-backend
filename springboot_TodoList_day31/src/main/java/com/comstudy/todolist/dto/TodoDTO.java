package com.comstudy.todolist.dto;

import com.comstudy.todolist.domain.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoDTO {
    private String no;
    private String userId;
    private String title;
    private boolean done;

    // Entity => DTO 변경
    public TodoDTO(final TodoEntity entity){
        this.no = entity.getNo();
        this.userId = entity.getUserId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }

    // DTO => Entity
    public static TodoEntity toEntity(final TodoDTO dto){
        return TodoEntity.builder().no(dto.getNo())
                .title(dto.getTitle())
                .done(dto.isDone()).build();
    }

    public TodoEntity toEntity() {
        return TodoEntity.builder().no(no)
                .userId(userId)
                .title(title)
                .done(done).build();
    }

}