package com.organization.newsfetchapplication.model;

public class Source {
    private int source_id;
    private String name;
    private String country;

    public Source(int source_id, String name, String country) {
        this.source_id = source_id;
        this.name = name;
        this.country = country;
    }

    public int getSource_id() {
        return source_id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
