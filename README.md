
# Advanced Library Management System

**Author**: Hossein Tatar  
**Student Number**: 40133014  

## Project Overview

The **Advanced Library Management System** is a Java-based application designed to manage books, members, and transactions within a library. It allows users to perform various operations such as borrowing and returning books, managing member information, and viewing details of the library's inventory. The project is built with a strong focus on object-oriented programming (OOP) principles and best practices.

## Features

1. **Member Management**:  
   - Each member is identified by a unique `memberId` (6 characters long) and has a name.
   - Members can borrow up to three books at a time.
   - The system tracks borrowed books and allows members to return them once finished.
   - Members can view their personal information and the list of borrowed books.

2. **Book Management**:  
   - Each book is identified by an `id` (5 characters long) and includes details such as title, author, and availability.
   - The system ensures that books are only borrowed when available and can be returned after use.
   - Users can view detailed information about each book, including the borrow count.

3. **Library Operations**:  
   - The library manages collections of books and members.
   - New books and members can be added to the library.
   - The system allows for borrowing and returning books while ensuring availability and proper record-keeping.
   - The full list of books and members can be displayed, providing an overview of the library’s resources.

4. **Concurrency in Borrow/Return**:
   - The system ensures that multiple books can be borrowed or returned simultaneously using the `borrowBook` and `returnBook` methods.

5. **Java Documentation (JavaDoc)**:
   - All classes and methods are documented using JavaDoc, explaining parameters and return types.

## Classes

### 1. **Book Class**
   - **Attributes**:
     - `id`: A unique string (exactly 5 characters).
     - `title`: The title of the book.
     - `author`: The author's name.
     - `isAvailable`: A boolean indicating whether the book is available (default is true).
   - **Methods**:
     - `printBookInfo()`: Prints detailed information about the book, including its availability and borrow count.

### 2. **Member Class**
   - **Attributes**:
     - `memberId`: A unique string (exactly 6 characters).
     - `name`: The member's name.
     - `borrowedBooks`: A list or array of `Book` objects, with a maximum of 3 books at a time.
   - **Methods**:
     - `borrowBook(Book book)`: Allows a member to borrow a book if they have borrowed fewer than 3 books and the book is available.
     - `returnBook(Book book)`: Allows a member to return a borrowed book.
     - `printMemberInfo()`: Prints the member's details, including the list of borrowed books.

### 3. **Library Class**
   - **Attributes**:
     - `name`: The library's name.
     - `books`: A collection of `Book` objects.
     - `members`: A collection of `Member` objects.
   - **Methods**:
     - `addBook(Book book)`: Adds a new book to the library.
     - `addMember(Member member)`: Adds a new member to the library.
     - `borrowBook(Member member, Book book)`: Allows a member to borrow a book if it is available.
     - `returnBook(Member member, Book book)`: Allows a member to return a borrowed book.
     - `printLibraryInfo()`: Prints the details of the library, including all books and members.

## Git Workflow

- Each class (`Book`, `Member`, `Library`) was developed in a separate branch and merged into the main branch after completing the implementation.
- Proper commit messages were used, and at least one commit was made per class during the development process.
- The final integration was done ensuring all functionalities were properly merged into the main branch.

## Requirements

- **Java 8 or later**
- **Git** for version control

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Hossein8201/Advanced-Library-Management-System.git
   ```
2. Compile and run the project using your preferred Java IDE or from the command line.

## Usage

1. Add members and books to the system.
2. Borrow and return books using the methods provided in the `Member` and `Library` classes.
3. View the library's information, including books and members.

## Contributions

Contributions are welcome! Feel free to fork the repository and submit pull requests for new features or bug fixes.
