package Library;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class Manager here.
 * 
 * @Brandon Hinds
 * @version 1.1
 */
public class Manager
{
    private ArrayList<Student> students = new ArrayList<Student>();
    
    public void addStudent(Student student)
    {
        students.add(student);
        Collections.sort(students);
        writeToFile();
    }
    
    public void removeStudent(String name)
    {
        int index;
        
        Collections.sort(students);
        index = Collections.binarySearch(students, new Student(name, ""));
        
        students.remove(index);
        writeToFile();
    }
    
    public Student findStudent(String name)
    {   
        int index;
        
        Collections.sort(students);
        index = Collections.binarySearch(students, new Student(name, ""));
        
        return students.get(index);
    }
    
    public void updateStudent(Student student)
    {
        removeStudent(student.getName());
        addStudent(student);
    }
    
    public ArrayList<Student> getStudents()
    {
        return students;
    }
    
    public void start()
    {
        try
        {
            Scanner filescan = new Scanner(new File("Loan-Manager.txt"));
            
            while(filescan.hasNext())
            {
                String line[] = filescan.next().split(",");
                
                Book bk = new Book(line[2],line[3],line[4],line[5]);
                addStudent(new Student(line[0],line[1],bk));
            }
        }
        catch(IOException ex)
        {
            System.out.println("Could Not Read From File");
        }
        catch(Exception err)
        {
            System.out.println("Unknown Error Occured");
        }
    }
    
    private void writeToFile()
    {
        try
        {
            String message = "";
            PrintWriter writer = new PrintWriter("Loan-Manager.txt");
            
            for(Student student: students)
            {
                message += student.getInfo()+"\n";
            }
            
            writer.println(message);
            
            writer.close();
        }
        catch(IOException ex)
        {
            System.out.println("Error Reading File");
        }
    }
}
