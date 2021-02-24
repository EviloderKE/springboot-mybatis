package com.springbootmybatis.domain.po;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TestJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
