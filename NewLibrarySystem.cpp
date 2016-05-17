#include <iostream>
#include "LibrarySystem.h"

int main(int argc, char**argv)
{
    Book book = makeBook("1220", "Adventures", "Matthew", "Penguin");
    Student student = makeStudent("Adrian", "5T", book);

    cout<<"\t\t\tBook Details\n";
    cout<<"------------------------------------------\n\n";
    cout<<"ISBN:      "<<book.getISBN()<<"\n";
    cout<<"Name:      "<<book.getName()<<"\n";
    cout<<"Author:    "<<book.getAuthor()<<"\n";
    cout<<"Publisher: "<<book.getPublisher()<<"\n";
    cout<<"Student:   "<<student.getName()<<"\n";
    cout<<"Class:     "<<student.getClass()<<"\n";

    return 0;
}
