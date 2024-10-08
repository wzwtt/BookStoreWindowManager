package csc8011;

import java.util.ArrayList;

public class BookStoreWindow {
    private String name;
    private ArrayList<Book> books;

    public BookStoreWindow(String name, ArrayList<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books=books;
    }

    public Book maxValue() {
        Book max = new Book("0", "", 0, 0.0);
        for (Book book : books) {
            if (book.getValue() > max.getValue()) {
                max = book;
            }
        }
        return max;
    }

    public Book oldestBook() {
        Book oldest = new Book("0", "", 0, 0.0);
        for (Book book : books) {
            if (book.getValue() < oldest.getValue()) {
                oldest = book;
            }
        }
        return oldest;
    }


    public double averageValue() {
        double average = 0;
        int count=0;
        for (Book book : books) {
            average += book.getValue();
            count++;
        }
        return average / count;
    }
}
