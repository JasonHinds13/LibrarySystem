package Library;


/**
 * Write a description of class Book here.
 * 
 * @Brandon Hinds
 * @version 1.1
 */
public class Book
{
    private int ISBN;
    private String name;
    private String author;
    private String publisher;
    
    public Book(int ISBN, String name, String author, String publisher)
    {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public void setISBN(int ISBN)
    {
        this.ISBN = ISBN;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }
    
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    
    public int getISBN()
    {
        return ISBN;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public String getPublisher()
    {
        return publisher;
    }
    
    public String toString()
    {
        String message = "";
        
        message += "ISBN: "+ISBN;
        message += "Name: "+name;
        message += "Author: "+author;
        message += "Publisher: "+publisher;
        
        return message;
    }
}
