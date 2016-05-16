package Library;


/**
 * Write a description of class Student here.
 * 
 * @Brandon Hinds
 * @version 1.1
 */
public class Student implements Comparable<Student>
{
    private String name;
    private String Class;
    private Book book;
    
    public Student(String name, String Class)
    {
        this.name = name;
        this.Class = Class;
    }
    
    public Student(String name, String Class, Book book)
    {
        this.name = name;
        this.Class = Class;
        this.book = book;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setClass(String Class)
    {
        this.Class = Class;
    }
    
    public void setBook(Book book)
    {
        this.book = book;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getSClass()
    {
        return Class;
    }
    
    public Book getBook()
    {
        return book;
    }
    
    public int compareTo(Student other)
    {
        int result;
        
        result = name.compareTo(other.getName());
        
        return result;
    }
    
    public String toString()
    {
        String message = "";
        
        message += "Name: "+name;
        message += "Class: "+Class;
        message += book.toString();
        
        return message;
    }
}
