package com.comstudy.saramjpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="SARAM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaramEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String id;
    private String name;
    private int age;
}
