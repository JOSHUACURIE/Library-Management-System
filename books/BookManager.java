package books;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BookManager {

    private Set<Book> books = new HashSet<>();
    private Scanner input = new Scanner(System.in);
public void addBooks() {

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


//  BufferedWriter  FileWriter writer=new FileWriter("student/student.txt",true);
//         System.out.println("Enter your Name: ");
//             Name=input.nextLine();
//           writer.write("Name: "+Name +"\n");
        
//         System.out.println("Enter Your registration number: ");
//             regNo=input.nextInt();
//             input.nextLine();
//          writer.write("Admission Number: " +regNo+"\n");
        
//         System.out.println("Enter you form: ");
//             form=input.nextInt();
//             input.nextLine();
//          writer.write("Form: "+form+"\n");

//         System.out.println("What is your gender: ");
//             gender=input.nextLine();
//          writer.write("Gender: "+gender+"\n");
        
//         System.out.println("Enter you stream: ");
//             stream=input.nextLine();
//         writer.write("Stream : "+stream+"\n");

//         System.out.println("Finally Enter your password: ");
//            password=input.nextInt();
//            input.nextLine();     

//         writer.write("Password: "+password+"\n");
//         writer.write("--------------------------\n");
//         System.out.println("Congratulations You have succesfully created your account");

//          writer.close();
//         }catch(IOException e){
//             e.printStackTrace();
//             System.out.println("An error has occured.If the issue persists contact the admin");
//         }
//     }