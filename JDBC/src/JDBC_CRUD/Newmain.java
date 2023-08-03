package JDBC_CRUD;

import java.util.Scanner;

public class Newmain {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Enter 1 to Get");
            System.out.println("Enter 2 to Delete");
            System.out.println("Enter 3 to Post");
            System.out.println("Enter 4 to Exit");
            int a= sc.nextInt();
            if(a==1){
                StudentDao.showdata();

            }
            else if(a==2){
                System.out.println("Enter UserId to Del");
                int userid=sc.nextInt();
                boolean ans=StudentDao.deletedata(userid);
                if(ans==true){
                    System.out.println("Deleted SucessFully");
                }
                else{
                    System.out.println("Not Deleted");
                }
            }
            else if(a==3){
                System.out.println("Enter FirstName");
                String first=sc.next();
                System.out.print("Enter LastName");
                String last=sc.next();
                System.out.println("Enter Age");
                int age=sc.nextInt();

                // create Student obj
                Student st=new Student(first,last,age);
                System.out.println(st);   // invokes myObject.toString()

                boolean ans=StudentDao.insertdata(st);
                if(ans==true){
                    System.out.println("Inserted Sucessfully");
                }
                else{
                    System.out.println("Something Went Wrong");
                }
            }
            else if(a==4){
                break;
            }
        }
        System.out.println("Thanks for using CRUD JDBC Application");

    }
}
