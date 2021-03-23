package com.komencar.backend.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubscribePK implements Serializable {

    private User user;

    private Model model;
}
