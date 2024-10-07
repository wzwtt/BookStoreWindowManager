package csc8011;

import java.util.*;
import java.io.*;

public class BookStoreWindowIO {

    static String ShopName = "";
    static Scanner in = new Scanner(System.in);
    static Book[] books = new Book[10000];

    public static String showOptions() {
        String choice = "";
        while (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4"))) {
            System.out.println("Book Store Window");
            System.out.println("1. Enter the name of the book store");
            System.out.println("2. Read in information on the books from a .csv file in the current directory called books.csv.");
            System.out.println("3. Print a summary of the book store name followed by a list of all books, their value and the year published to the console.");
            System.out.println("4. Print statistics on books, showing the full details of the book with the highest value, oldest book displayed in the window, and average value of books displayed in the window of the book store, to the console");
            System.out.println("5. Exit");
            System.out.println();
            System.out.println("Enter your choice: ");
            choice = in.nextLine();
            if (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4"))) {
                System.out.println("Invalid choice. Try again.");
                System.out.println();
            }
        }
        return choice;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int number =0;
        switch (showOptions()) {
            case "1":
                System.out.println("Enter the name of the book store: ");
                ShopName = in.nextLine();
                System.out.println("Accepted");
                break;
            case "2":
                File file = new File("books.csv");
                Scanner ReadFile = new Scanner(file);
                while (ReadFile.hasNextLine()) {
                    String data = ReadFile.nextLine();
                    books[number].setID()=;
                    number++;
                }
                ReadFile.close();
        }

    }
}
