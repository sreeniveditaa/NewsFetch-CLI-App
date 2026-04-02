package com.organization.newsfetchapplication.model;

import java.time.LocalDate;

public class Article {
    private int id;
    private String title;
    private String content;
    private String url;
    private Category category;
    private Source source;
    private LocalDate publishedDate;

    public Article(int id, String title, String content, String url,Category category, Source source, LocalDate publishedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.url = url;
        this.category=category;
        this.source=source;
        this.publishedDate = publishedDate;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public Category getCategory() {
        return category;
    }

    public Source getSource() {
        return source;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    @Override
    public String toString() {
        return id + " | " + title + " | " +
                category + " | " +
                source.getName() + " | " +
                publishedDate;
    }
}
