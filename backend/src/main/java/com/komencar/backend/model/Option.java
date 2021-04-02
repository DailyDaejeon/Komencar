package com.komencar.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Option {

    @Id
    @Column(name = "o_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "o_name")
    private String name;

    @Column(name = "o_price")
    private int price;


    @ManyToOne
    @JoinColumn(name = "md_id")
    @JsonBackReference
    private Model_Detail modelDetail;


}
