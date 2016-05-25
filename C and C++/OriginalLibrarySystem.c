#include <stdio.h>
#include <stdlib.h> //This library is used for the the exit function
#include <string.h> //This is used for operations with strings
#include <windows.h> //This is for added effects to the program

struct books{ //This struct is a model of the main information we want from each book

    int ISBN; //The ISBN Of The Book
    char name[100]; //The Name Of The Book
    char author[100]; //The Author Of The Book
    char publisher[100]; //The Publisher Of The Book
    char SName[100]; //The Name Of The Student who borrowed the book
    char Class[10]; //The class of the student who borrowed the book
};

//Function Declaration

int login(); //This function is where the user will login
int menu(); //This function is where the user will get to do whatever options are available
int LoanBook(); //This function will allow the user to add books to the database of books loaned
int ReturnBook(); //This function will manage the books being returned to the library
int SearchBook(); //This function will allow the user to search for a specific book
int ViewRecord(); //This function will allow the user to view all books that have been loaned

//Global Variables
int count; //This is a counter and will also serve as the index for the array which holds the struct
int bookn; //This will be used to accept the number of books the user wants to enter
int tries = 3; //The maximum amount of tries to enter the password in the login function
int attempts = 0; //This is used in the login function

struct books library[4000]; //This array will hold the information of all books borrowed

int main(){

    system("color 17"); //This will add color to the program

    login();

    return 0;
}

int login()
{
    system("cls");

    char passn[5]; //Password The User Will Enter
    int count = 0; //Counter Variable
    char p;

    attempts++;

    printf("Please Enter The Password To Continue\n");
    printf("\nYou Have %d Try/Tries Remaining\n", (tries - attempts+1));
    printf("\n");
    printf("Password: ");

    //This while loop is for entering and concealing the password
    while(passn[count] != 13){
        passn[count] = getch();
        p = passn[count];
        if (p == 13) break;
        else printf("*");
        count++;
    }

    passn[count]='\0';

    count = 0;

    if (strcmp(passn, "pass")== 0){

    //These next few lines of code is just for fun

	system("cls");

	for (count = 0; count< 6; count++)
        {
            printf("\t\t\t Loading Library System |");
            Sleep(100);
            system("cls");

            printf("\t\t\t Loading Library System /");
            Sleep(100);
            system("cls");

            printf("\t\t\t Loading Library System -");
            Sleep(100);
            system("cls");

        }

        system("cls");

	//Fun Over

        menu();
    }

    else{
        printf("\n");
        if (attempts < tries){
        printf("\nThe Password is Incorrect...\n\a");
        printf("\nPress Any Key To Try Again...\n");
        getch();
        printf("\n");
        }
        if (attempts >= tries){
            printf("\nThe Password is Incorrect...\n\a");
            printf("\n");
            printf("--------------------------------------\n");
            printf("\nYou Have Exeeded Your Login Attempts\n");
            printf("--------------------------------------\n");
            printf("\n");
            printf("Press Any Key To Exit...\n");
            getch();
            exit(0);
        }
        else{
            return main();
        }
    }
}

int menu(){

    system("cls");

    fflush(stdin);

	char choice; //This is the users choice of what to do in this program

	printf("\n");
    printf("\n****** Welcome To The St. Jago High School Library's Book Keeping System! ******\n");
    printf("\n");

    printf("What Would You Like To Do?\n");
    printf("Choose An Option By Selecting The Corresponding Letter.\n");
    printf("\n");

    printf("a. To Loan A Book To A Student.\n");
    printf("b. To Return A Book Previously Loaned To A Student.\n");
    printf("c. To Search For A Book Loaned To A Student.\n");
    printf("d. To View All Records of Books Loaned.\n");
    printf("e. To Exit This Program.\n");

    printf("\n");

    printf("Choice: ");
    choice = getch();

    if (choice == 'a'){
    	LoanBook(); //This will direct the user to function LoanBook
    }

    else if (choice == 'b'){
    	ReturnBook(); //This will direct the user to function ReturnBook
    }

    else if (choice == 'c'){
    	SearchBook(); //This will direct the user to function SearchBook
    }

    else if (choice == 'd'){
    	ViewRecord(); //This will direct the user to function ViewRecord
    }

    else if (choice == 'e'){
    	exit(0); //The user can leave the program through this option
    }

    else{ //If the user enters anything than what is supposed to be entered:
        printf("That Is Not An Option!\n");

        system("pause");

        return menu(); //An error message will be printed and the program will return to menu
    }
}

int LoanBook(){ //This is the function to add books to the file

    fflush(stdin);

    system("cls");

	FILE*rental;
	rental = fopen("Loaned_Books.txt","a");

	printf("How Many Books Are Being Loaned?\n");
	scanf("%d", &bookn);

	for (count = 0; count < bookn; count++){
		printf("Enter The Book Name:\n");
		scanf("%s",&library[count].name);
    	printf("Enter The Book ISBN:\n");
		scanf("%d",&library[count].ISBN);
		printf("Enter The Book Author:\n");
		scanf("%s",&library[count].author);
		printf("Enter The Book Publisher:\n");
		scanf("%s",&library[count].publisher);
		printf("Enter The Name Of The Student Who Borrowed The Book:\n");
		scanf("%s",&library[count].SName);
		printf("Enter The Class Of The Student Who Borrowed The Book:\n");
		scanf("%s",&library[count].Class);
		printf("\n");

		fprintf(rental, "%s\n" ,library[count].name);
		fprintf(rental, "%d\n" ,library[count].ISBN);
		fprintf(rental, "%s\n" ,library[count].author);
		fprintf(rental, "%s\n" ,library[count].publisher);
        fprintf(rental, "%s\n" ,library[count].SName);
		fprintf(rental, "%s\n" ,library[count].Class);
		fprintf(rental, "\n");
	}

	printf("**************************************************************\n");
	printf("                          DONE :)                             \n");
	printf("**************************************************************\n");
	system("pause");

	fclose(rental);

	return menu(); //The program returns to menu at the end of the function
}

int ReturnBook()
{
    system("cls");

    fflush(stdin);

    FILE*borrow;
    FILE*borrow2;

    borrow = fopen("Loaned_Books.txt", "r");

    char nsearch[100];

    if (borrow == NULL){ //If the file is empty or does not exist:
		printf("I'm Sorry But Information From The Rental Database Cannot Be Retrieved Right Now.\n");
		system("pause");

		return menu(); //The error message will be printed and the program returns to menu
	}

	else
    {
        borrow2 = fopen("Loaned_copy.txt", "a");
    }

	printf("What Is The Name Of The Book Being Returned?\n");
    scanf("%s", &nsearch);

	for (count = 0; count < 4000; count++){

        fscanf(borrow, "%s\n" ,&library[count].name);
        fscanf(borrow, "%d\n" ,&library[count].ISBN);
        fscanf(borrow, "%s\n" ,&library[count].author);
        fscanf(borrow, "%s\n" ,&library[count].publisher);
        fscanf(borrow, "%s\n" ,&library[count].SName);
        fscanf(borrow, "%s\n" ,&library[count].Class);
    }

    for (count = 0; count < 4000; count++){

        if (strcmp(nsearch, library[count].name) == 0){
            printf("____________________________________________________________________\n");
            printf("Book Info no.%d\n", count + 1);
            printf("Name: %s\n", library[count].name);
            printf("ISBN: %d\n", library[count].ISBN);
            printf("Author: %s\n", library[count].author);
            printf("Publisher: %s\n" ,library[count].publisher);
            printf("Borrower's Name: %s\n" ,library[count].SName);
            printf("Borrower's Class: %s\n" ,library[count].Class);
            printf("\n");
            printf("This Book Has Been Returned\n");
            printf("____________________________________________________________________\n");
        }

        else {

            if (strcmp("", library[count].name) != 0){

            fprintf(borrow2, "%s\n" ,&library[count].name);
            fprintf(borrow2, "%d\n" ,&library[count].ISBN);
            fprintf(borrow2, "%s\n" ,&library[count].author);
            fprintf(borrow2, "%s\n" ,&library[count].publisher);
            fprintf(borrow2, "%s\n" ,&library[count].SName);
            fprintf(borrow2, "%s\n" ,&library[count].Class);
            fprintf(borrow2, "\n");

            }
        }
    }

    printf("**************************************************************\n");
	printf("                          DONE :)                             \n");
	printf("**************************************************************\n");
	system("pause");

    fclose(borrow);
    fclose(borrow2);

    remove("Loaned_Books.txt");
    rename("Loaned_copy.txt", "Loaned_Books.txt" );

    return menu();
}

int SearchBook(){ //This is the function to search the file for a book previously entered

    system("cls");

    fflush(stdin);

    FILE*rental;

	rental = fopen("Loaned_Books.txt","r");

	char nsearch[100]; //This will be used to find the name of the book

	if (rental == NULL){ //If the file is empty or does not exist:
		printf("I'm Sorry But Information From The Rental Database Cannot Be Retrieved Right Now.\n");
		system("pause");

		return menu(); //The error message will be printed and the program returns to menu
	}

	else{

	    printf("Book Database Will Now Be Searched...\n");
	    printf("\n");

        printf("What Is The Name Of The Book?\n");
        scanf("%s", &nsearch);

        for (count = 0; count < 4000; count++){

            fscanf(rental, "%s\n" ,&library[count].name);
            fscanf(rental, "%d\n" ,&library[count].ISBN);
            fscanf(rental, "%s\n" ,&library[count].author);
            fscanf(rental, "%s\n" ,&library[count].publisher);
            fscanf(rental, "%s\n" ,&library[count].SName);
            fscanf(rental, "%s\n" ,&library[count].Class);
        }

        for (count = 0; count < 4000; count++){

            if (strcmp(nsearch, library[count].name) == 0){
                printf("____________________________________________________________________\n");
                printf("Book Info no.%d\n", count + 1);
                printf("Name: %s\n", library[count].name);
                printf("ISBN: %d\n", library[count].ISBN);
                printf("Author: %s\n", library[count].author);
                printf("Publisher: %s\n" ,library[count].publisher);
                printf("Borrower's Name: %s\n" ,library[count].SName);
                printf("Borrower's Class: %s\n" ,library[count].Class);
                printf("____________________________________________________________________\n");
            }
        }
	}

	fclose(rental);

	system("pause");

	return menu(); //The program returns to menu at the end of the function
}

int ViewRecord() //Function to view all records of books loaned
{
    fflush(stdin);

    system("cls");

    FILE*rental;

	rental = fopen("Loaned_Books.txt","r");

	if (rental == NULL){ //If the file is empty or does not exist:
		printf("I'm Sorry But Information From The Rental Database Cannot Be Retrieved Right Now.\n");
		system("pause");

		return menu(); //The error message will be printed and the program returns to menu
	}

	else{

        for (count = 0; count < 4000; count++){

            fscanf(rental, "%s\n" ,&library[count].name);
            fscanf(rental, "%d\n" ,&library[count].ISBN);
            fscanf(rental, "%s\n" ,&library[count].author);
            fscanf(rental, "%s\n" ,&library[count].publisher);
            fscanf(rental, "%s\n" ,&library[count].SName);
            fscanf(rental, "%s\n" ,&library[count].Class);
        }

        for (count = 0; count < 4000; count++){
            if (strcmp("", library[count].name) != 0){
                printf("____________________________________________________________________\n");
                printf("Book Info no.%d\n", count + 1);
                printf("Name: %s\n", library[count].name);
                printf("ISBN: %d\n", library[count].ISBN);
                printf("Author: %s\n", library[count].author);
                printf("Publisher: %s\n" ,library[count].publisher);
                printf("Borrower's Name: %s\n" ,library[count].SName);
                printf("Borrower's Class: %s\n" ,library[count].Class);
                printf("____________________________________________________________________\n");
            }
        }
	}

	fclose(rental);

	system("pause");

	return menu(); //The program returns to menu at the end of the function
}
