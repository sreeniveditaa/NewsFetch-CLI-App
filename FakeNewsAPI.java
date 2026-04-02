package com.organization.newsfetchapplication.external;

import com.organization.newsfetchapplication.model.Article;
import com.organization.newsfetchapplication.model.Category;
import com.organization.newsfetchapplication.model.Source;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeNewsAPI {
    public static List<Article> fetch(int page){
        Source s1 = new Source(1,"BBC","UK");
        Source s2 = new Source(2,"CNN","America");
        Source s3 = new Source(3,"News 18","India");

        List<Article> list = new ArrayList<>();
        if(page==1){
            list.add(new Article(1, "AI is booming",
                    "AI content...", "url1",
                    Category.TECH, s1,
                    LocalDate.now()));
        }
        else if(page==2){
            list.add(new Article(2, "Stock market rises",
                    "Finance content...", "url2",
                    Category.BUSINESS, s2,
                    LocalDate.now().minusDays(1)));
        }
        else if(page==3){
            list.add(new Article(3,"Dhurandhar : massive sucess",
                    "Dhurandhar crosses 2000+ cr","url3",Category.ENTERTAINMENT,s3,
                    LocalDate.now().minusDays(1)));
        }
        return list;
    }
}
