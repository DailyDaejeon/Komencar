package com.komencar.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Fuel {

    @Id
    @Column(name = "f_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long f_id;

    @Column(name = "f_name")
    private String f_name;

//    @OneToMany(mappedBy = "fuel")
//    private List<Model_Detail> modelDetailList = new ArrayList<>();
}
