package com.comstudy.boardweb.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="BOARD", uniqueConstraints = {@UniqueConstraint(columnNames = "seq")})
@Data
public class Board {
    @Id
    @GeneratedValue
    @Column(name = "SEQ")
    private Long seq;
    private String title;
    private String writer;
    private String content;
    private Date writeDate = new Date();
    private int cnt = 0;
}
