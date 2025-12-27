package admin;
import java.io.*;
import java.util.*;


public class AdminManager {
private Set<Admin> admin=new HashSet<>();
private Scanner input=new Scanner(System.in);
private static final String FILE_PATH="admin/admin.txt";

public AdminManager(){
    loadAdminFromFile();
}

private void loadAdminFromFile(){
    File file=new File(FILE_PATH);
    if(!file.exists()) return;

    try(Scanner fs=new Scanner(file)){


  while (fs.hasNextLine()) {
    String line= fs.nextLine().trim();
    if(line.isEmpty()) continue;

    String [] data=line.split(",");
    if(data.length !=4) continue;
    
    Admin a=new Admin(data[0],data[1],data[2],data[3]);

    admin.add(a);

  }

System.out.println("Admin loaded successfully");
    } catch(Exception e){
        e.printStackTrace();
        System.out.println("An error has occured");
    }

}


private void saveAdminToFile(Admin admin){
try {
    new File("admin").mkdirs();
    BufferedWriter bw=new BufferedWriter(new FileWriter(FILE_PATH,true));
    bw.write(admin.toString());
    bw.newLine();
    bw.close();
    
} catch (IOException e) {
   e.printStackTrace();
}
}

public void createAdmin() {
    // Check if an admin already exists
    if (!admin.isEmpty()) {
        System.out.println("Admin already exists. Cannot create more than one.");
        return;
    }

    System.out.print("Enter your name: ");
    String name = input.nextLine();

    System.out.print("Enter the Work Number: ");
    int workno = input.nextInt();
    input.nextLine(); 

    System.out.print("Enter role: ");
    String role = input.nextLine();

    String password;
    while (true) {
        System.out.print("Enter a 6-digit password: ");
        password = input.nextLine();
        if (password.length() == 6) break;
        System.out.println("Weak password. Try again.");
    }

   Admin ad=new Admin(name, password, password, password);

    admin.add(ad);
    saveAdminToFile(ad);

    System.out.println("Admin created successfully.");
}
 public Admin login(){
    System.out.println("Enter your Work No: ");
    String workno=input.nextLine();
    
    System.out.println("Enter your password: ");
    String pass=input.nextLine();

    for(Admin a: admin){
        if(a.getWorkNo().equals(workno) && a.getPassword().equals(pass)){
            System.out.println("Login successful");
            return a;
        }
    }
 System.out.println("Wrong Credentials");
    return null;
 }
    
}