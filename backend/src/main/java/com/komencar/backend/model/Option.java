package com.komencar.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Option {

    @Id
    @Column(name = "o_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long o_id;

    @Column(name = "o_name")
    private String o_name;

    @Column(name = "o_price")
    private int o_price;

    @ManyToOne
    @JoinColumn(name = "md_id")
    private Model_Detail model_detail;


}
