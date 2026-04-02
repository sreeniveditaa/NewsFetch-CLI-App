package com.organization.newsfetchapplication.service;

import com.organization.newsfetchapplication.external.FakeNewsAPI;
import com.organization.newsfetchapplication.model.Article;
import com.organization.newsfetchapplication.model.Category;
import com.organization.newsfetchapplication.repository.ArticleRepository;

import java.time.LocalDate;
import java.util.List;

public class NewsService {
    private ArticleRepository repo = new ArticleRepository();

    public void fetchAndStoreNews() {
        int page=1;
        while (true) {
            List<Article> articles = FakeNewsAPI.fetch(page);
                if (articles.isEmpty()) {
                    break;
                }
                for (Article a : articles) {
                    repo.save(a);
                }
                page++;
            }
            System.out.println("All pages fetched successfully!");
    }
    public void viewAllNews() {
        if (repo.getAll().isEmpty()) {
            System.out.println("No news available.");
            return;
        }

        for (Article a : repo.getAll()) {
            System.out.println(a);
        }
    }

    public void searchByKeyword(String keyword) {
        boolean found = false;

        for (Article a : repo.getAll()) {
            if (a.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(a);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching articles found.");
        }
    }
    public void filterByCategory(Category category) {
        boolean found = false;

        for (Article a : repo.getAll()) {
            if (a.getCategory() == category) { // enum comparison
                System.out.println(a);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No articles in this category.");
        }
    }
    public void filterByDate(LocalDate searchDate){
        boolean found=false;
        for(Article a : repo.getAll()){
            if(a.getPublishedDate().equals(searchDate)){
                System.out.println(a);
                found = true;
            }
        }
        if(!found){
            System.out.println("No articles in this date.");
        }
    }


}
