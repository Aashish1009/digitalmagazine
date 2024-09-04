package com.cts;

import com.cts.dao.MagazineDAO;
import com.cts.dao.ArticleDAO;
import com.cts.dao.SubscriptionDAO;
import com.cts.dao.UserDAO;
import com.cts.model.Magazine;
import com.cts.model.Article;
import com.cts.model.Subscription;
import com.cts.model.User;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MagazineDAO magazineDAO = new MagazineDAO();
        ArticleDAO articleDAO = new ArticleDAO();
        SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
        UserDAO userDAO = new UserDAO();

        while (true) {
            System.out.println("----- Digital Magazine Management System -----");
            System.out.println("1. Add Magazine");
            System.out.println("2. View Magazines");
            System.out.println("3. Update Magazine");
            System.out.println("4. Delete Magazine");
            System.out.println("5. Add Article");
            System.out.println("6. View Articles");
            System.out.println("7. Update Article");
            System.out.println("8. Delete Article");
            System.out.println("9. Subscribe to Magazine");
            System.out.println("10. View Subscriptions");
            System.out.println("11. Update Subscription");
            System.out.println("12. Cancel Subscription");
            System.out.println("13. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    magazineDAO.addMagazine(getMagazineDetails(scanner));
                    break;
                case 2:
                    magazineDAO.getAllMagazines().forEach(System.out::println);
                    break;
                case 3:
                    magazineDAO.updateMagazine(getMagazineDetails(scanner));
                    break;
                case 4:
                    System.out.print("Enter Magazine ID to delete: ");
                    int magId = scanner.nextInt();
                    magazineDAO.deleteMagazine(magId);
                    break;
                case 5:
                    articleDAO.addArticle(getArticleDetails(scanner));
                    break;
                case 6:
                    articleDAO.getAllArticles().forEach(System.out::println);
                    break;
                case 7:
                    articleDAO.updateArticle(getArticleDetails(scanner));
                    break;
                case 8:
                    System.out.print("Enter Article ID to delete: ");
                    int artId = scanner.nextInt();
                    articleDAO.deleteArticle(artId);
                    break;
                case 9:
                    subscriptionDAO.addSubscription(getSubscriptionDetails(scanner));
                    break;
                case 10:
                    subscriptionDAO.getAllSubscriptions().forEach(System.out::println);
                    break;
                case 11:
                    subscriptionDAO.updateSubscription(getSubscriptionDetails(scanner));
                    break;
                case 12:
                    System.out.print("Enter Subscription ID to cancel: ");
                    int subId = scanner.nextInt();
                    subscriptionDAO.cancelSubscription(subId);
                    break;
                case 13:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static Magazine getMagazineDetails(Scanner scanner) {
        System.out.print("Enter Magazine Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Genre: ");
        String genre = scanner.nextLine();
        System.out.print("Enter Publication Frequency: ");
        String frequency = scanner.nextLine();
        System.out.print("Enter Publisher: ");
        String publisher = scanner.nextLine();

        return new Magazine(title, genre, frequency, publisher);
    }

    private static Article getArticleDetails(Scanner scanner) {
        System.out.print("Enter Article Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Magazine ID: ");
        int magazineId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter Content: ");
        String content = scanner.nextLine();
        System.out.print("Enter Publish Date (yyyy-mm-dd): ");
        String publishDate = scanner.nextLine();

        return new Article(magazineId, title, author, content, publishDate);
    }

    private static Subscription getSubscriptionDetails(Scanner scanner) {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter Magazine ID: ");
        int magazineId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Subscription Date (yyyy-mm-dd): ");
        String subscriptionDate = scanner.nextLine();
        System.out.print("Enter Expiry Date (yyyy-mm-dd): ");
        String expiryDate = scanner.nextLine();
        System.out.print("Enter Status (active/inactive): ");
        String status = scanner.nextLine();

        return new Subscription(userId, magazineId, subscriptionDate, expiryDate, status);
    }
}
