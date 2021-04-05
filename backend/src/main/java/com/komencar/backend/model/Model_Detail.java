package com.komencar.backend.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Model_Detail {

    @Id
    @Column(name = "md_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "md_name")
    private String name;

    @Column(name = "md_effciency")
    private double effciency;

    @Column(name = "md_exhaust")
    private int exhaust;

    @Column(name = "md_max_person")
    private int max_person;

    @ManyToOne
    @JoinColumn(name = "f_id")
    private Fuel fuel;

    @ManyToOne
    @JoinColumn(name = "m_id")
    private Model model;


    @OneToMany(mappedBy = "modelDetail")
    @JsonManagedReference
    private List<Option> optionList = new ArrayList<>();

}
