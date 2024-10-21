import java.util.*;
/**
 * <h1>This is the Main body of Library Management System</h1>
 * In this class we handle and order the changes in the hole of Program and this is the only class that
 * we can give it the values from the outside.
 * <p>
 * <b>Note:</b> We don't add this property to give from outside in this version.
 *
 * @author Hossein Tatar - 40133014
 * @version 1.0
 * @since 2021-10-21
 */
public class Main {
    /**
     * <h3>Method to simulate the outputs and working Classes</h3>
     * In this method we add book, member and borrow or return the books and other things to be <b>sure correct working</b> of each Class.
     * @return nothing
     */
    public static void main(String[] args) {
        //Creating a new library
        Library library = new Library("Hossein Library");
        //Adding at least 5 books to the library
        Book book1 = new Book("00001","math","Euler",Genre.SCIENCE,Genre.NON_FICTION);
        book1.capitalizeTitle();
        Book book2 = new Book("00002","physics","Stephen William Hawking",Genre.SCIENCE);
        book2.capitalizeTitle();
        Book book3 = new Book("00003","Material engineering","Euler",Genre.SCIENCE,Genre.HISTORY);
        book3.capitalizeTitle();
        Book book4 = new Book("00004","linear Algebra","Stephen William Hawking",Genre.SCIENCE,Genre.FICTION,Genre.FANTASY);
        book4.capitalizeTitle();
        Book book5 = new Book("00005","Circuits","Albert Tun",Genre.SCIENCE);
        //Adding books to the library's collection
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        //Adding at least 2 members to the library
        Address addressMember1 = new Address("Sabzevar", "Bahonar", "00001");
        Address addressMember2 = new Address("Tehran", "Azadi", "00002");
        Member member1 = new Member("000001", "Ali", addressMember1);
        Member member2 = new Member("000002", "Reza", addressMember2);
        //Adding members to the library's member collection
        library.addMember(member1);
        library.addMember(member2);
        //Simulating borrowing books by members
        library.borrowBook(member1, book1);     //Ali borrows book1
        library.borrowBook(member1, book2, book3, book4);     //Ali borrows book2 and book3 and book4
        library.borrowBook(member2, book4);     //Reza attempts to borrow book4 (already borrowed)
        library.borrowBook(member2, book5);     //Reza borrows book5
        //Simulating returning books
        library.returnBook(member1, book1, book3);     //Ali returns book1 and book3
        library.returnBook(member2, book2);     //Reza attempts to return book2 (don't borrowed by him)
        library.returnBook(member2, book5);     //Reza returns book5
        //For two time:
        library.borrowBook(member2, book1, book3);
        library.borrowBook(member1, book5);
        library.returnBook(member1, book2, book4);
        //Sort books and find the books :
        library.sortBooksByTitle();
        List<String> bookWrittenByAuthor = library.findBooksByAuthor("Euler");
        System.out.println(bookWrittenByAuthor);
        //Printing library information (all books and members)
        library.printLibraryInfo();
        //Adding more books and members as needed to check the condition of book id and member id.
        Book book = new Book("133","math","Golf",Genre.SCIENCE,Genre.HISTORY);      //the length of id must be exactly 5 character
        Address addressMember3 = new Address("Sabzevar", "Nejat", "0003");
        Member member3 = new Member("44444", "Mohammad", addressMember3);   //the length of id must be exactly 6 character
        //attempts to add this book and member to library (that can't)
        library.addMember(member3);
        library.addBook(book);
        //Print the updated library information after adding new member and book
        library.printLibraryInfo();
    }
}