package admin;
import java.util.*;

import library.Library;
 public class Admin implements Library{
  Scanner input=new Scanner(System.in);
  
    @Override
    public void addBooks() {
        System.out.println("Which book do you want to borrow");
        
    }
@Override
public void borrow() {
  
    

    
}


@Override
public void Return() {
   
    
}

@Override
public void Count() {
   
    
}
@Override
public void Supply() {
   
    
}
@Override
public void deleteBooks() {
  
    
}

@Override
public void libraryMenu() {
  System.out.println("Welcome to Leraa Library");
  System.out.println("Who are you? Student or Admin");
  
  System.out.println("1.Add Books\n2.Book Supplies\n3.Book Returning\n4.Count Books\n5.Delete Books\n6.Book Borrowing");
  System.out.print("What do you want to do?: ");
  int choice=input.nextInt();


switch (choice) {
    case 1:
      addBooks();
       break;
    case 2:
      Supply();
       break;
    case 3:
      Return();
       break;
    case 4:
     Count();
       break;
    case 5:
      deleteBooks();
      break;
    case 6:
      borrow();
      break;
    default:
    System.out.println("Not available");
        break;
}

}
}