package student;

import java.io.*;
import java.util.*;

public class StudentManager {

    private Set<Student> students = new HashSet<>();
    private Scanner input = new Scanner(System.in);
    private static final String FILE_PATH = "student/students.txt";

    public StudentManager() {
        loadStudentsFromFile(); 
    }


    private void loadStudentsFromFile() {
        File file = new File(FILE_PATH);

        if (!file.exists()) return;

        try (Scanner fs = new Scanner(file)) {
            while (fs.hasNextLine()) {
                String line = fs.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] data = line.split(",");
                if (data.length != 6) continue;

                Student s = new Student(
                    data[0], data[1], data[3],
                    Integer.parseInt(data[4]),
                    Integer.parseInt(data[2]),
                    data[5]
                );

                students.add(s);
            }
            System.out.println("Students loaded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void saveStudentToFile(Student student) {
        try {
            new File("student").mkdirs();
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true));
            bw.write(student.toString());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    public void enroll() {
        System.out.print("How many students? ");
        int count = input.nextInt();
        input.nextLine();

        for (int i = 1; i <= count; i++) {
            System.out.println("Student " + i);

            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Gender: ");
            String gender = input.nextLine();

            System.out.print("Form: ");
            int form = input.nextInt();
            input.nextLine();

            System.out.print("Stream: ");
            String stream = input.nextLine();

            System.out.print("Reg No: ");
            int regNo = input.nextInt();
            input.nextLine();

            System.out.print("Password: ");
            String password = input.nextLine();

            Student s = new Student(name, gender, stream, regNo, form, password);

            if (students.add(s)) {
                saveStudentToFile(s);
                System.out.println("Student added.");
            } else {
                System.out.println("Duplicate admission number.");
            }
        }
        studentMenu();
    }

   
    public Student login() {
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your password: ");
        String pass = input.nextLine();

        for (Student s : students) {
            if (s.getName().equals(name) && s.getPassword().equals(pass)) {
                System.out.println("Login successful.");
                return s;
            }
        }

        System.out.println("Wrong credentials.");
        return null;
    }

    public void studentMenu() {
        System.out.println("\n--- Student Menu ---");
        System.out.println("1. Borrowed Books");
        System.out.println("2. View Charges");
        System.out.println("3. New Arrivals");
        System.out.println("4. Complains & Suggestions");
        System.out.println("5. Send Reviews");
    }

    public void welcomeMenu() {
        System.out.println("Welcome to Leraa Library! We have missed you.");
        System.out.println("1. Login\n2. Create Account");
        int choice = input.nextInt();
        input.nextLine();

        if (choice == 1) {
            Student s = login();
            if (s != null) studentMenu();
        } else if (choice == 2) {
            enroll();
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
