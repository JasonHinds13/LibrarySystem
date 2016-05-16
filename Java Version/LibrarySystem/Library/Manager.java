package Library;

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
    
    public Student findStudent(String name)
    {   
        int index;
        
        Collections.sort(students);
        index = Collections.binarySearch(students, new Student(name, ""));
        
        return students.get(index);
    }
    
    public void addStudent(Student student)
    {
        students.add(student);
    }
    
    public void removeStudent(String name)
    {
        int index;
        
        Collections.sort(students);
        index = Collections.binarySearch(students, new Student(name, ""));
        
        students.remove(index);
    }
    
    public ArrayList<Student> getStudents()
    {
        return students;
    }
}
