package com.komencar.backend.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    @Column(name="u_email")
    private String u_email;

    @Column(name="u_name")
    private String u_name;

    @OneToMany(mappedBy = "user")
    private List<Subscribe> SubscribeList = new ArrayList<>();
}
