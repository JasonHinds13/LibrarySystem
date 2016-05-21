package Library;


/**
 * Write a description of class Book here.
 * 
 * @Brandon Hinds
 * @version 1.1
 */
public class Book
{
    private String ISBN;
    private String name;
    private String author;
    private String publisher;
    
    public Book(String ISBN, String name, String author, String publisher)
    {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
    }

    public void setISBN(String ISBN)
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
    
    public String getISBN()
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
    
    public String getInfo()
    {
        String message = "";
        
        message += ISBN+","+name+","+author+","+publisher;
        
        return message;
    }
    
    public String toString()
    {
        String message = "";
        
        message += "ISBN: "+ISBN+"\n";
        message += "Book: "+name+"\n";
        message += "Author: "+author+"\n";
        message += "Publisher: "+publisher;
        
        return message;
    }
}
