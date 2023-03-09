package com.comstudy.todolist.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="TODO")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TodoEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;  // 오브젝트 아이디
    private String userId;
    private String title;
    private boolean done;
}
