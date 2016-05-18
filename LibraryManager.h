#include <string>
#include <sstream>
#include <fstream>
#include "LibrarySystem.h"

int size_s = 0;
Student students[100];

//Functions Declaration
void addStudent(Student student);
void delStudent(string name);
void updateStudent(Student student);
void writeToFile();
void readFromFile();
Student findStudent(string name);

void addStudent(Student student)
{
    students[size_s] = student;
    size_s++;
    writeToFile();
}

void delStudent(string name)
{
    for(int c = 0; c < size_s; c++)
    {
        if(name.compare(students[c].getName()) == 0)
        {
            //insert a blank student that we check for later
            Book bk = makeBook("","","","");
            students[c] = makeStudent("blank","blank",bk);
        }
    }

    writeToFile();
}

void updateStudent(Student student)
{
    for(int c = 0; c < size_s; c++)
    {
        if(student.getName().compare(students[c].getName()) == 0)
        {
            students[c] = student;
        }
    }

    writeToFile();
}

Student findStudent(string name)
{
    for(int c = 0; c < size_s; c++)
    {
        if(name.compare(students[c].getName()) == 0)
        {
            return students[c];
        }
    }
}

void writeToFile()
{
    ofstream file;
    file.open("Loan-Manager.txt");

    for(int c = 0; c < size_s; c++)
    {
        if(students[c].getName() != "blank" && students[c].getClass() != "blank")
        {
            file << students[c].getName() <<" ";
            file << students[c].getClass() <<" ";
            file << students[c].getBook().getISBN() <<" ";
            file << students[c].getBook().getName() <<" ";
            file << students[c].getBook().getAuthor() <<" ";
            file << students[c].getBook().getPublisher() <<"\n";
        }
    }

    file.close();
}

void readFromFile()
{
    string line;
    ifstream infile("Loan-Manager.txt");

    if(infile)
    {
        while(getline(infile,line))
        {
            string sName, sClass;
            string bISBN, bName, auth, pub;

            istringstream ss(line);

            ss >> sName >> sClass >> bISBN >> bName >> auth >> pub;

            if (sName.compare("") != 0 || sName.compare(" ") != 0)
            {
                Book bk = makeBook(bISBN,bName,auth,pub);
                addStudent(makeStudent(sName,sClass,bk));

                size_s++;
            }
        }
    }
}
