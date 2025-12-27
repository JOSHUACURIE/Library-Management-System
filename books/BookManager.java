package books;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BookManager {

    private Set<Book> books = new HashSet<>();
    private Scanner input = new Scanner(System.in);
public void addBookss() {

    System.out.print("How many books do you want to add? ");
    int count = input.nextInt();
    input.nextLine();

    for (int i = 1; i <= count; i++) {
        System.out.println("Enter details of book " + i);

        System.out.print("Title: ");
        String title = input.nextLine();

        System.out.print("Author: ");
        String author = input.nextLine();

        System.out.print("ISBN: ");
        String isbn = input.nextLine();

        Book book = new Book(title, author, isbn);

        if (books.add(book)) {
            saveBookToFile(book);
            System.out.println("Book added");
        } else {
            System.out.println("Duplicate book (ISBN exists)");
        }
    }
}
private void saveBookToFile(Book book) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("books/books.txt", true))) {
        bw.write(book.toString());
        bw.newLine();
    } catch (IOException e) {
        System.out.println("Error saving book");
    }
}

    
}

