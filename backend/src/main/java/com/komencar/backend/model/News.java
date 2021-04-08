package com.komencar.backend.model;

import lombok.Data;

@Data
public class News {
    private String title;
    private String description;
    private String pubDate;
    private String originallink;
    private String link;

    public News() {
    }

    public News(String title, String description, String pubDate, String originallink, String link) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.originallink = originallink;
        this.link = link;
    }
}
