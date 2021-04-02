package com.komencar.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Segment {

    @Id
    @Column(name = "s_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long s_id;

    @Column(name = "s_name")
    private String s_name;

//    @OneToMany(mappedBy = "segment")
//    private List<Model> modelList = new ArrayList<>();
}