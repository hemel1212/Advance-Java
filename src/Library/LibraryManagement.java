package Library;



import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagement {
    private static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        ReadFromDatabase readData = new ReadFromDatabase();
        // Initialize the library with some books


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. List of books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    listBooks();
                    break;
                case 2:
                    borrowBook(scanner);
                    break;
                case 3:
                    returnBook(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void listBooks() {
        for (Book book : books) {
            book.display();
        }
        System.out.println("Press Enter to return to the menu.");
        new Scanner(System.in).nextLine();
    }

    private static void borrowBook(Scanner scanner) {
        while (true) {
            System.out.print("Enter the title of the book to borrow (or type 'exit' to return to the menu): ");
            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("exit")) {
                break;
            }

            boolean found = false;
            for (Book book : books) {
                if (book.title.equalsIgnoreCase(title)) {
                    found = true;
                    if (book.available) {
                        book.available = false;
                        System.out.println("You have successfully borrowed '" + book.title + "'.");
                    } else {
                        System.out.println("Sorry, '" + book.title + "' is currently not available.");
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("Book not found in the library.");
            }
        }
    }

    private static void returnBook(Scanner scanner) {
        while (true) {
            System.out.print("Enter the title of the book to return (or type 'exit' to return to the menu): ");
            String title = scanner.nextLine();
            if (title.equalsIgnoreCase("exit")) {
                break;
            }

            boolean found = false;
            for (Book book : books) {
                if (book.title.equalsIgnoreCase(title)) {
                    found = true;
                    if (!book.available) {
                        book.available = true;
                        System.out.println("Thank you for returning '" + book.title + "'.");
                    } else {
                        System.out.println("'" + book.title + "' was not borrowed.");
                    }
                    break;
                }
            }

            if (!found) {
                System.out.println("Book not found in the library.");
            }
        }
    }
}