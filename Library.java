import java.util.*;
/**
 * <h1>Class for Libraries and their members and books</h1>
 * In this class we define the attribute of a library and connection of that with members and books and how behave.
 * <p>
 * @author Hossein Tatar - 40133014
 * @version 1.0
 * @since 2024-10-21
 */
public class Library {
    /*
    First we define the variables of this class
     */
    /** <b>name</b> is a String type. */
    private String name;
    /** <b>books</b> is a collection of Book objects. */
    private Collection<Book> books;
    /** <b>members</b> is a collection of Member objects. */
    private Collection<Member> members;
    /**
     * <h3>Constructor method of Library class</h3>
     * this method creates an object of Library class.
     * @param name is an input value of String type.
     * @return nothing
     */
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }
    /*
    Next we need to use getter and setter to apply the changes for private variables.
     */
    /** Getter method to get the value of name parameter.
     * @return String type. */
    public String getName() {return name;}
    /** Getter method to get a collection of Books parameter.
     * @return Collection type. */
    public Collection<Book> getBooks() {return books;}
    /** Getter method to get a collection of members parameter.
     * @return Collection type. */
    public Collection<Member> getMembers() {return members;}
    /*
    Now we identify the Setter method.
     */
    /** Setter method to change the value of name.
     * @param name is input value.
     * @return nothing. */
    public void setName(String name) {this.name = name;}
    /**
     * This method do the <b>adding book process</b> for a library.<p>
     * @param bookList is input value and the object with Array type of Book class members that must be added, we don't know have many they are.
     * @return nothing
     */
    public void addBook(Book... bookList) {
        for (Book book : bookList) {
            if (books.contains(book))   System.out.println("Book with id '" + book.getId() + "' is already exists in "+ name + " library.");
            else if (book == null)   System.out.println("Book with id '" + book.getId() + "' does not identified.");
            else books.add(book);
        }
    }
    /**
     * This method do the <b>adding member process</b> for a library.<p>
     * @param memberList is input value and the object with Array type of Member class members that must be added, we don't know have many they are.
     * @return nothing
     */
    public void addMember(Member... memberList) {
        for (Member member : memberList) {
            if (members.contains(member))   System.out.println("Member with id '" + member.getMemberId() + "' is already exists in "+ name + " library.");
            else if (member == null)   System.out.println("Member with id '" + member.getMemberId() + "' does identified.");
            else members.add(member);
        }
    }



    //Method to borrow many books for a member
    public void borrowBook(Member member, Book... bookList) {
        if (!members.contains(member))
            System.out.println("#####Member with id '" + member.getMemberId() + "' don't added to the library");
        for (Book book : bookList) {
            if (!books.contains(book))
                System.out.println("#####Book with id '" + book.getId() + "' don't added to the library");
            else    member.borrowBook(book);
        }
    }
    //Method to return many books for a member
    public void returnBook(Member member, Book... bookList) {
        if (!members.contains(member))
            System.out.println("#####Member with id '" + member.getMemberId() + "' don't added to the library");
        for (Book book : bookList) {
            if (!books.contains(book))
                System.out.println("#####Book with id '" + book.getId() + "' don't added to the library");
            else    member.returnBook(book);
        }
    }
    //Create printMemberInfo method
    public void printLibraryInfo() {
        System.out.println("----Name: " + name);
        System.out.println("----Books of the Library: ");
        int numberIndex = 1;
        for (Book book : books) {
            System.out.println(">>>Book: '" + numberIndex++ + "' :");
            book.printBookInfo();
        }if (books.isEmpty()) System.out.println("Don't exist any books in the library");
        System.out.println("----Members of the Library: ");
        numberIndex = 1;
        for (Member member : members) {
            System.out.println(">>>Member: '" + numberIndex++ + "' :");
            member.printMemberInfo();
        }if (members.isEmpty()) System.out.println("Don't exist any members in the library");
    }
}
