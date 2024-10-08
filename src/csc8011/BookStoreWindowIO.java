package csc8011;

import java.util.*;
import java.io.*;

public class BookStoreWindowIO {

    static BookStoreWindow store = new BookStoreWindow("",new ArrayList<>());
    static Scanner in = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();

    public static String showOptions() {
        String choice = "";
        while (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5"))) {
            System.out.println();
            System.out.println("Book Store Window");
            System.out.println("1. Enter the name of the book store");
            System.out.println("2. Read in information on the books from a .csv file in the current directory called books.csv.");
            System.out.println("3. Print a summary of the book store name followed by a list of all books, their value and the year published to the console.");
            System.out.println("4. Print statistics on books, showing the full details of the book with the highest value, oldest book displayed in the window, and average value of books displayed in the window of the book store, to the console");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            choice = in.nextLine();
            if (!(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5"))) {
                System.out.println("Invalid choice. Try again.");
                System.out.println();
            }
        }
        return choice;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String choice;
        boolean done1 = false, done2 = false;
        do {
            choice = showOptions();
            switch (choice) {
                case "1":
                    System.out.println("Enter the name of the book store: ");
                    store.setName(in.nextLine());
                    System.out.println("Accepted.");
                    done1 = true;
                    break;
                case "2":
                    System.out.println("Accepted, reading from the books.csv file...");
                    File file = new File("books.csv");
                    Scanner ReadFile = new Scanner(file);
                    while (ReadFile.hasNextLine()) {
                        String data = ReadFile.nextLine();
                        String[] datas = data.split(",");
                        books.add(new Book(datas[0], datas[1], Integer.parseInt(datas[2]), Double.parseDouble(datas[3])));
                    }
                    ReadFile.close();
                    store.setBooks(books);
                    System.out.println("Done.");
                    done2 = true;
                    break;
                case "3":
                    if (!(done1&&done2)) {
                        System.out.println();
                        System.out.println("You must finish option 1 and option 2 first.");
                        break;
                    }
                    System.out.println("Book shop name: " + store.getName());
                    for (Book book : books) {
                        System.out.println("Book Id: " + book.getID() + ", Title: " + book.getTitle() + ", Year published: " + book.getYear() + ", Value: £" + String.format("%.2f", book.getValue()));
                    }
                    break;
                case "4":
                    if (!(done1&&done2)) {
                        System.out.println();
                        System.out.println("You must finish option 1 and option 2 first.");
                        break;
                    }
                    System.out.println("The statistics on highest value, oldest book, and average value of the books:");
                    System.out.println("Highest value book: " + store.maxValue().getTitle() + " (published " + store.maxValue().getYear() + "), £" + String.format("%.2f", store.maxValue().getValue()));
                    System.out.println("Oldest book: " + store.oldestBook().getTitle() + " (published " + store.oldestBook().getYear() + ")");
                    System.out.println("Average value of books: £" + String.format("%.2f", store.averageValue()));
                    break;
            }
        } while (!choice.equals("5"));
    }
}
