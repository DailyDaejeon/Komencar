package com.komencar.backend.model;

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
    private long md_id;

    @Column(name = "md_name")
    private String md_name;

    @Column(name = "md_effciency")
    private double md_effciency;

    @Column(name = "md_exhaust")
    private int md_exhaust;

    @Column(name = "md_max_person")
    private int md_max_person;

    @ManyToOne
    @JoinColumn(name = "f_id")
    private Fuel fuel;

    @ManyToOne
    @JoinColumn(name = "m_id")
    private Model model;

//    @OneToMany(mappedBy = "model_detail")
//    private List<Option> optionList = new ArrayList<>();
}
