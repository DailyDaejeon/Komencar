package com.komencar.backend.model;

import lombok.Data;

@Data
public class News {
    private long news_id;
    private String news_title;
    private String news_description;
    private String news_date;
    private String news_company;


}
