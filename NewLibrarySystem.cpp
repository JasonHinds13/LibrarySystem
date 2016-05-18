#include <iostream>
#include "LibraryManager.h"

//functions
void menu();
void addOne();
void findOne();
void deleteOne();
void updateOne();
void viewAll();

int main(int argc, char**argv)
{
    menu();
    return 0;
}

void menu()
{
    bool running = true;
    char opt;

    readFromFile();

    std::cout<<"*========* Welcome To The Library *========*\n";

    while(running)
    {
        std::cout<<"\nChoose An Option Below:\n";
        std::cout<<"A. Add Student\n";
        std::cout<<"B. Search For Student\n";
        std::cout<<"C. Delete Student\n";
        std::cout<<"D. Update Student\n";
        std::cout<<"E. View All Students\n";
        std::cout<<"F. Exit Program\n";
        cin >> opt;

        if(opt == 'A' || opt == 'a')
        {
            addOne();
        }
        else if(opt == 'B' || opt == 'b')
        {
            findOne();
        }
        else if(opt == 'C' || opt == 'c')
        {
            deleteOne();
        }
        else if(opt == 'D' || opt == 'd')
        {
            updateOne();
        }
        else if (opt == 'E' || opt == 'e')
        {
            viewAll();
        }
        else if(opt == 'F' || opt == 'f')
        {
            running = false;
        }
    }
}

void addOne()
{
    string sName, sClass;
    string bISBN, bName, auth, pub;

    std::cout <<"\nEnter Student Name: ";
    cin >> sName;
    std::cout <<"\nEnter Student Class: ";
    cin >> sClass;
    std::cout <<"\nEnter Book ISBN: ";
    cin >> bISBN;
    std::cout <<"\nEnter Book Name: ";
    cin >> bName;
    std::cout <<"\nEnter Book Author: ";
    cin >> auth;
    std::cout <<"\nEnter Book Publisher: ";
    cin >> pub;

    Book bk = makeBook(bISBN,bName,auth,pub);
    addStudent(makeStudent(sName,sClass,bk));
}

void findOne()
{
    string sName;

    std::cout <<"\nEnter Student Name: ";
    cin >> sName;

    Student found = findStudent(sName);

    cout<<"------------------------------------------\n";
    cout<<"ISBN:      "<<found.getBook().getISBN()<<"\n";
    cout<<"Name:      "<<found.getBook().getName()<<"\n";
    cout<<"Author:    "<<found.getBook().getAuthor()<<"\n";
    cout<<"Publisher: "<<found.getBook().getPublisher()<<"\n";
    cout<<"Student:   "<<found.getName()<<"\n";
    cout<<"Class:     "<<found.getClass()<<"\n";
    cout<<"------------------------------------------\n";
}

void deleteOne()
{
    string sName;

    std::cout <<"\nEnter Student Name: ";
    cin >> sName;

    delStudent(sName);
}

void updateOne()
{
    string sName, sClass;
    string bISBN, bName, auth, pub;

    std::cout <<"Enter Student Name: ";
    cin >> sName;
    std::cout <<"\nEnter Student Class: ";
    cin >> sClass;
    std::cout <<"\nEnter Book ISBN: ";
    cin >> bISBN;
    std::cout <<"\nEnter Book Name: ";
    cin >> bName;
    std::cout <<"\nEnter Book Author: ";
    cin >> auth;
    std::cout <<"\nEnter Book Publisher: ";
    cin >> pub;

    Book bk = makeBook(bISBN,bName,auth,pub);
    updateStudent(makeStudent(sName,sClass,bk));
}

void viewAll()
{
    for(int c = 0; c < size_s; c++)
    {
        if(students[c].getName() != "blank" && students[c].getClass() != "blank")
        {
            std::cout <<"--------------------------------\n";
            std::cout <<"Student Name: " << students[c].getName() <<"\n";
            std::cout <<"Student Class: " << students[c].getClass() <<"\n";
            std::cout <<"Book ISBN: " << students[c].getBook().getISBN() <<"\n";
            std::cout <<"Book Name: " << students[c].getBook().getName() <<"\n";
            std::cout <<"Book Author: " << students[c].getBook().getAuthor() <<"\n";
            std::cout <<"Book Publisher: " << students[c].getBook().getPublisher() <<"\n";
            std::cout <<"--------------------------------\n";
        }
    }
}
