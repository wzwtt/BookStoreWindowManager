package csc8011;

public class Book {
    private final String ID;
    private final String Title;
    private final int year;
    private final double value;

    public Book(String ID, String Title, int year, double value) {
        this.ID = ID;
        this.Title = Title;
        this.year = year;
        this.value = value;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public int getYear() {
        return year;
    }

    public double getValue() {
        return value;
    }

}
