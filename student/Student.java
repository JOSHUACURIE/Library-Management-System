package student;
import java.util.*;

import books.Book;

import java.io.FileWriter;
import java.util.*;
import java.io.IOException;
import java.io.BufferedWriter;
public class Student {
    String Name,gender,stream;
    int regNo,form,password;



    public Student(String Name, String gender, String stream,int regNo,int form,int password) {
        this.Name=Name;
        this.gender=gender;
        this.stream=stream;
        this.regNo=regNo;
        this.form=form;
        this.password=password;

    }

private Set<Student> students=new HashSet<>();
Scanner input =new Scanner(System.in);

    public void enroll(){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("/students/students.txt")) ){

      System.out.print("How many students do you want to add? ");
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

        Student student = new Student(Name,gender,stream,regNo,form,password);

        if (students.add(student)) {
            saveStudentToFile(student);
            System.out.println("Book added");
        } else {
            System.out.println("Duplicate book (ISBN exists)");
        }
    }

 }catch(IOException e){
            e.printStackTrace();
            System.out.println("An error has occured");
        }
    }
private void saveStudentToFile(Student student) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("students/students.txt", true))) {
        bw.write(student.toString());
        bw.newLine();
    } catch (IOException e) {
        System.out.println("Error saving book");
    }
}

    void login(){
        System.out.println("Enter your name: ");
        String name=input.nextLine();
        System.out.println("Enter your password: ");
        int pass=input.nextInt();
        input.nextLine();
        if(name!=Name &&  pass!=password){
            System.out.println("Wrong credentials");
        }else{
            studentMenu();
        }

    }





    void borrowedBooks(){}
    void viewCharges(){}
    void newArrivals(){}
    void sendSuggestions(){}
    void sendReviews(){}
   public void welcomeMenu(){
        System.out.println("Welcome to Leraa Library,We have missed you");
        System.out.println("1.Login\n2.Create account");
        int choice=input.nextInt();
        input.nextLine();
        if(choice==1){
            login();
        } else if(choice==2){
            enroll();
        }
        
    }
    void studentMenu(){

    }
}
