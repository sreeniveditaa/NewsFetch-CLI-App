import com.organization.newsfetchapplication.model.Category;
import com.organization.newsfetchapplication.service.NewsService;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NewsService service = new NewsService();
        while(true){
            System.out.println("\n--- News CLI ---");
            System.out.println("1. Fetch News");
            System.out.println("2. View All News");
            System.out.println("3. Search by Keyword");
            System.out.println("4. Filter by Category");
            System.out.println("5. Filter by Date");
            System.out.println("6. Exit");

            int choice = Integer.parseInt(sc.nextLine());
            switch(choice){
                case 1:
                    service.fetchAndStoreNews();
                    break;

                case 2:
                    service.viewAllNews();
                    break;
                case 3:
                    System.out.println("Enter the keyword:");
                    String keyword = sc.nextLine();
                    service.searchByKeyword(keyword);
                    break;
                case 4:
                    System.out.println("Categories: TECH, SPORTS, BUSINESS, HEALTH, ENTERTAINMENT");
                    System.out.print("Enter category: ");
                    String catInput = sc.nextLine().toUpperCase();

                    try {
                        Category category = Category.valueOf(catInput);
                        service.filterByCategory(category);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid category!");
                    }
                    break;
                case 5:
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String dateStr = sc.nextLine();

                    try {
                        LocalDate date = LocalDate.parse(dateStr);
                        service.filterByDate(date);
                    } catch (Exception e) {
                        System.out.println("Invalid date format!");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }
}