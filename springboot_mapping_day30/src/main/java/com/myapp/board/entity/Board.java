package com.myapp.board.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Board {
    @Id
    @GeneratedValue
    private Integer seq;
    private String title;
//    private String writer;
    private String content;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;
    private Integer cnt;

    // 연관관계 매핑
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;
}
