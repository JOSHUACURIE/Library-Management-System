package books;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BookManager {

    private Set<Book> books = new HashSet<>();
    private Scanner input = new Scanner(System.in);

    public void addBooks() {
  try (BufferedWriter bw = new BufferedWriter(new FileWriter("books/books.txt",true))) {

      System.out.print("How many books do you want to add? ");
        int count = input.nextInt();
        input.nextLine();

        for (int i = 1; i <= count; i++) {
            System.out.println("Enter details of book " + i);

            System.out.print("Title: ");
            String title = input.nextLine();
            bw.write("Title: "+title+"\n");

            System.out.print("Author: ");
            String author = input.nextLine();
            bw.write("Author: "+author+"\n");

            System.out.print("ISBN: ");
            String isbn = input.nextLine();
            bw.write("ISBN: "+isbn+"\n");

            bw.write("---------------\n");

            Book book = new Book(title, author, isbn);

            if (!books.add(book)) {
                System.out.println("Duplicate book (ISBN exists)");
            }
        }
           
            System.out.println("Books saved successfully");
        } catch (IOException e) {
            System.out.println("Error saving books");
        }
      
    }

    
}
