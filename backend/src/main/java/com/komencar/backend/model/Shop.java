package com.komencar.backend.model;

import lombok.Data;

@Data
public class Shop {
    private String title;
    private String link;
    private String image;
    private String lprice;
    private String hprice;
    private String mallName;

    public Shop(){}

    public Shop(String title, String link, String image, String lprice, String hprice, String mallName) {
        this.title = title;
        this.link = link;
        this.image = image;
        this.lprice = lprice;
        this.hprice = hprice;
        this.mallName = mallName;
    }
}
