package csc8011;

public class Book {
    private String ID;
    private String Title;
    private int year;
    private double value;

    public Book(String ID, String Title, int year, double value) {
        this.ID = ID;
        this.Title = Title;
        this.year = year;
        this.value = value;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }


}
