package com.organization.newsfetchapplication.repository;

import com.organization.newsfetchapplication.model.Article;

import java.util.Collection;
import java.util.HashMap;

public class ArticleRepository {
    private HashMap<String, Article> articlemap = new HashMap<>();

    public void save(Article article){
        articlemap.put(article.getUrl(),article);
    }

    public Collection<Article> getAll(){
        return articlemap.values();
    }
}
