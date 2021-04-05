package com.komencar.backend.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(mappedBy = "model")
    @JsonManagedReference
    private List<Model_Detail> modelDetailList = new ArrayList<>();

    public Model(){}

    public Model(long id, String name, String manufacturer, Segment segment, List<Model_Detail> modelDetailList) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.segment = segment;
        this.modelDetailList = modelDetailList;
    }
}
