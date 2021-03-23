package com.komencar.backend.model;

import javax.persistence.*;

@Entity
@IdClass(SubscribePK.class)
public class Subscribe {

    @Id
    @ManyToOne
    @JoinColumn(name="u_email")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name="m_id")
    private Model model;
}
