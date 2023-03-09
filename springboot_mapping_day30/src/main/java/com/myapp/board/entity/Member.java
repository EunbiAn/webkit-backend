package com.myapp.board.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@ToString(exclude = "boardList")
public class Member {
    @Id
    private String id;
    private String password;
    private String name;
    private String role;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Board> boardList= new ArrayList<>();
}
