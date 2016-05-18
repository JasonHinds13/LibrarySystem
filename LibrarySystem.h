#include <iostream>

using namespace std;

//Book class
class Book
{
private:

    string ISBN; //The ISBN Of The Book
    string name; //The Name Of The Book
    string author; //The Author Of The Book
    string publisher; //The Publisher Of The Book

public:

    void setISBN(string isbn)
    {
        ISBN = isbn;
    }

    void setName(string nam)
    {
        name = nam;
    }

    void setAuthor(string auth)
    {
        author = auth;
    }

    void setPublisher(string pub)
    {
        publisher = pub;
    }

    string getISBN()
    {
        return ISBN;
    }

    string getName()
    {
        return name;
    }

    string getAuthor()
    {
        return author;
    }

    string getPublisher()
    {
        return publisher;
    }

};

//student class
class Student
{
private:
    string name; //name of student
    string Class; //class student is in
    Book book; //book the student borrowed

public:

    void setName(string myname)
    {
        name = myname;
    }

    void setClass(string myclass)
    {
        Class = myclass;
    }

    void setBook(Book bk)
    {
        book = bk;
    }

    string getName()
    {
        return name;
    }

    string getClass()
    {
        return Class;
    }

    Book getBook()
    {
        return book;
    }
};

//functions declaration
Book makeBook(string ISBN, string name, string author, string publisher);
Student makeStudent(string name, string Class, Book book);

Book makeBook(string ISBN, string name, string author, string publisher)
{
    Book newbook;

    newbook.setISBN(ISBN);
    newbook.setName(name);
    newbook.setAuthor(author);
    newbook.setPublisher(publisher);

    return newbook;
}

Student makeStudent(string name, string Class, Book book)
{
    Student student;

    student.setName(name);
    student.setClass(Class);
    student.setBook(book);

    return student;
}
