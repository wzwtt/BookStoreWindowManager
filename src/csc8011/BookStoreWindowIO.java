package csc8011;

import java.util.*;
import java.io.*;

public class BookStoreWindowIO {

    static BookStoreWindow store = new BookStoreWindow("", new ArrayList<>());
    static Scanner in = new Scanner(System.in);

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
            outerswitch:
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
                        String[] Cdata = data.split(",");
                        try {
                            store.addBook(new Book(Cdata[0], Cdata[1], Integer.parseInt(Cdata[2]), Double.parseDouble(Cdata[3])));
                        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                            System.out.println("Invalid data. Try again.");
                            System.out.println();
                            ReadFile.close();
                            break outerswitch;
                        }
                    }
                    ReadFile.close();
                    System.out.println("Done.");
                    done2 = true;
                    break;
                case "3":
                    if (!(done1 && done2)) {
                        System.out.println();
                        System.out.println("You must finish option 1 and option 2 first.");
                        break;
                    }
                    System.out.println("Book shop name: " + store.getName());
                    for (int i = 0; i < store.getAmountOfBooks(); i++) {
                        System.out.println("Book Id: " + store.getBook(i).getID() + ", Title: " + store.getBook(i).getTitle() + ", Year published: " + store.getBook(i).getYear() + ", Value: £" + String.format("%.2f", store.getBook(i).getValue()));
                    }
                    break;
                case "4":
                    if (!(done1 && done2)) {
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
