package com.komencar.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Model {

    @Id
    @Column(name = "m_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "m_name")
    private String name;

    @Column(name = "m_manufacturer")
    private String manufacturer;

    @ManyToOne
    @JoinColumn(name = "s_id")
    private Segment segment;

//    @OneToMany(mappedBy = "model")
//    private List<Model_Detail> modelDetailList = new ArrayList<>();

}
