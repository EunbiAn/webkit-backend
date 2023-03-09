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
    private String id;
    private String userId;
    private String title;
    private boolean done;

    // Entity => DTO 변경
    public TodoDTO(final TodoEntity entity){
        this.id = entity.getId();
        this.userId = entity.getUserId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }

    // DTO => Entity
    public static TodoEntity toEntity(final TodoDTO dto){
        return TodoEntity.builder().id(dto.getId())
                .title(dto.getTitle())
                .done(dto.isDone()).build();
    }

    public TodoEntity toEntity() {
        return TodoEntity.builder().id(id)
                .userId(userId)
                .title(title)
                .done(done).build();
    }

}