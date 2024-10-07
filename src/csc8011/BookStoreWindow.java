package csc8011;

public class BookStoreWindow {
    private String name;
    private Book[] books = new Book[10000];
    private final int number;

    public BookStoreWindow(String name, Book[] books, int number) {
        this.name = name;
        this.books = books;
        this.number = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book[] maxValue() {
        Book max = new Book("0", "", 0, 0.0);
        for (int i = 0; i < number; i++) {
            if (books[i].getValue() > max.getValue()) {
                max = books[i];
            }
        }
        return new Book[]{max};
    }

    public Book[] oldestBook() {
        Book oldest = new Book("0", "", 0, 0.0);
        for (int i = 0; i < number; i++) {
            if (books[i].getYear() < oldest.getYear()) {
                oldest = books[i];
            }
        }
        return new Book[]{oldest};
    }


    public double averageValue() {
        double average = 0;
        for (int i = 0; i < number; i++) {
            average += books[i].getValue();
        }
        return average / number;
    }
}
