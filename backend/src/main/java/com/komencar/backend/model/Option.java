package com.komencar.backend.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Option {

    @Id
    @Column(name = "o_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int o_id;

    @Column(name = "o_name")
    private String o_name;

    @ManyToOne
    @JoinColumn(name = "m_id")
    private Model model;

}
