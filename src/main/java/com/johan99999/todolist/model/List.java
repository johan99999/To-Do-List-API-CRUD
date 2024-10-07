package com.johan99999.todolist.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "todolist")
public class List {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "No")
    private int no;

    @Column(name = "List")
    @Max(100)
    private String list;

    @Enumerated(EnumType.STRING)
    @Column(name = "Finished")
    private Finished finished;

    @Column(name = "Time_Created")
    private LocalDateTime timeCreated;


    public enum Finished{
        YES,
        NO
    }
}
