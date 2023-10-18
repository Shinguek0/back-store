package com.roadhub.demonio.model;

import javax.persistence.*;

@MappedSuperclass
public class EntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    public  Long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }
}