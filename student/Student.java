package student;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
public class Student {
    String Name,gender,stream;
    int regNo,form,password;
Scanner input =new Scanner(System.in);

    public void enroll(){
        try{
        FileWriter writer=new FileWriter("student.txt",true);
        System.out.println("Enter your Name: ");
            Name=input.nextLine();
          writer.write("Name: "+Name +"\n");
        
        System.out.println("Enter Your registration number: ");
            regNo=input.nextInt();
            input.nextLine();
         writer.write("Admission Number: " +regNo+"\n");
        
        System.out.println("Enter you form: ");
            form=input.nextInt();
            input.nextLine();
         writer.write("Form: "+form+"\n");

        System.out.println("What is your gender: ");
            gender=input.nextLine();
         writer.write("Gender: "+gender+"\n");
        
        System.out.println("Enter you stream: ");
            stream=input.nextLine();
        writer.write("Stream : "+stream+"\n");

        System.out.println("Finally Enter your password: ");
           password=input.nextInt();
           input.nextLine();     

        writer.write("Password: "+password+"\n");
        writer.write("--------------------------\n");
        System.out.println("Congratulations You have succesfully created your account");

         writer.close();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("An error has occured.If the issue persists contact the admin");
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
