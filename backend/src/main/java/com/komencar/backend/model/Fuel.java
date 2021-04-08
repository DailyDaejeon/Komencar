package com.komencar.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Fuel {

    @Id
    @Column(name = "f_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "f_name")
    private String name;

//    @OneToMany(mappedBy = "fuel")
//    private List<Model_Detail> modelDetailList = new ArrayList<>();
}
