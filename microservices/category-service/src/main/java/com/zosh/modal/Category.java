package com.zosh.modal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String image;
    @Column(nullable = false)
    private Long saloonid;
//basic getter and setter method
//    public void setName(String name){
//        this.name = name;
//    }
//    public String getName(){
//        return name;
//    }
}
