package com.aku.pojo.vo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
@SuppressWarnings("all")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    private  String email;

    private Integer gender;

    @Column(name = "id_card")
    private Integer idCard;

    private Integer level;
}
