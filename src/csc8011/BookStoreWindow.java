package csc8011;

import java.util.ArrayList;

public class BookStoreWindow {
    private String name;
    private final ArrayList<Book> books;

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

    public void addBook(Book book) {
        books.add(book);
    }

    public int getAmountOfBooks() {
        return books.size();
    }

    public Book getBook(int index) {
        return books.get(index);
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
        Book oldest = new Book("", "", 9999, 0.0);
        for (Book book : books) {
            if (book.getYear() < oldest.getYear()) {
                oldest = book;
            }
        }
        return oldest;
    }


    public double averageValue() {
        double average = 0;
        int count = 0;
        for (Book book : books) {
            average += book.getValue();
            count++;
        }
        return average / count;
    }
}
