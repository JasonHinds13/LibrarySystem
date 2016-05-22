import Library.*;
import java.util.Scanner;

/**
 * Write a description of class LibraryTxtUI here.
 * 
 * @Brandon Hinds
 * @version 1.1
 */
public class LibraryTxtUI
{
    public static void main(String[] args)
    {
        String option;
        boolean running = true;
        Scanner scan = new Scanner(System.in);
        Manager manager = new Manager();
        
        manager.start();
        
        System.out.println("*======================* Welcome To The Library *======================*");
        
        while (running)
        {
            System.out.println("\nChoose An Option Below: ");
            System.out.println("A. Loan A Book");
            System.out.println("B. Find A Loaned Book");
            System.out.println("C. Update A Student");
            System.out.println("D. Return A Loaned Book");
            System.out.println("E. Display All Books on Loan");
            System.out.println("F. To Exit");
            
            System.out.println("Option: ");
            option = scan.nextLine();
            option = option.toUpperCase();
            
            if(option.equals("A"))
            {
                String sName,Class; //Student Info
                String ISBN, bName, author, publisher; //Book Info
                
                System.out.print("Enter Student Name: ");
                sName = scan.nextLine();
                System.out.print("Enter Students Class: ");
                Class = scan.nextLine();
                System.out.print("Enter Book ISBN: ");
                ISBN = scan.nextLine();
                System.out.print("Enter Book Name: ");
                bName = scan.nextLine();
                System.out.print("Enter Book Author: ");
                author = scan.nextLine();
                System.out.print("Enter Book Publisher: ");
                publisher = scan.nextLine();
                
                Book book = new Book(ISBN, bName, author, publisher);
                
                manager.addStudent(new Student(sName, Class, book));
            }
            else if(option.equals("B"))
            {
                String sName;
                
                System.out.print("Enter Student's Name To Find A Book: ");
                sName = scan.nextLine();
                
                System.out.println(manager.findStudent(sName));
            }
            else if(option.equals("C"))
            {
                String sName,Class; //Student Info
                String ISBN, bName, author, publisher; //Book Info
                
                System.out.print("Enter Student Name: ");
                sName = scan.nextLine();
                System.out.print("Enter Students Class: ");
                Class = scan.nextLine();
                System.out.print("Enter Book ISBN: ");
                ISBN = scan.nextLine();
                System.out.print("Enter Book Name: ");
                bName = scan.nextLine();
                System.out.print("Enter Book Author: ");
                author = scan.nextLine();
                System.out.print("Enter Book Publisher: ");
                publisher = scan.nextLine();
                
                Book book = new Book(ISBN, bName, author, publisher);
                
                manager.updateStudent(new Student(sName, Class, book));
            }
            else if(option.equals("D"))
            {
                String sName;
                
                System.out.print("Enter Student's Name To Remove A Book: ");
                sName = scan.nextLine();
                
                manager.removeStudent(sName);
            }
            else if(option.equals("E"))
            {
                for(Student student: manager.getStudents())
                {
                    System.out.println("---------------------------");
                    System.out.println(student);
                    System.out.println("---------------------------");
                }
            }
            else if(option.equals("F"))
            {
                running = false;
                System.out.println("Goodbye!");
            }
            else
            {
                System.out.println("***Not A Valid Option\n");
            }
        }
    }
}
