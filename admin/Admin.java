package admin;
import java.util.*;

public class Admin {

    private String name;
    private String workno;
    private String role;
    private String password;
    
    

public Admin(String n,String w,String p,String r){
    this.name=n;
    this.workno=w;
    this.password=p;
    this.role=r;

}


//getters
public String getName(){return name;}
public String getWorkNo(){return workno;}
public String getPassword(){return password;}

@Override
public boolean equals(Object o){

  if(this==o)return true;
  if(!(o instanceof Admin)) return false;
  Admin admin=(Admin) o;
  return role==admin.role;

}

@Override
public int hashCode(){
  return Objects.hash(role);
}

@Override
public String toString(){
  return name+","+role+","+workno+","+password;
}

}