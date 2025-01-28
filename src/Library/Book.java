package Library;
class Book {

    String title;
    private String author;
    int year;
    int pages;
    double price;
    boolean available;

    public Book(String title, String author, int year, int pages, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.price = price;
        this.available = true;
    }


    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year: " + year);
        System.out.println("Number of pages: " + pages);
        System.out.println("Price: " + price);
        System.out.println("Available: " + (available ? "Yes" : "No"));
        System.out.println("--------------------------------------");
    }
}