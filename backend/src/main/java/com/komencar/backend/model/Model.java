package com.komencar.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Model {

    @Id
    @Column(name="m_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long m_id;

    @Column(name="m_manufacturer")
    private String m_manufacturer;

    @Column(name="m_name")
    private String m_name;

    @Column(name="m_price")
    private String m_price;

    @Column(name="m_efficiency")
    private double m_efficiency;

    @OneToMany(mappedBy = "model")
    private List<Subscribe> subscribeList = new ArrayList<>();

    @OneToMany(mappedBy = "model")
    private List<Option> optionList = new ArrayList<>();
}
