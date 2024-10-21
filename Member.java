import java.util.*;
/**
 * <h1>Class for members and how their behave</h1>
 * In this class we define their attributes and properties.
 * <p>
 * @author Hossein Tatar - 40133014
 * @version 1.0
 * @since 2024-10-21
 */
public class Member {
    /*
    First we define the variables of this class
     */
    /** <b>memberId</b> is a <u>6 character</u> String type. */
    private String memberId;
    /** <b>name</b> is a String type. */
    private String name;
    /** <b>borrowedBooks</b> is a List type of Book class. */
    private List<Book> borrowedBooks;
    /** <b>address</b> is an object of Address class that saved the position for member. */
    private Address address;
    /**
     * <h3>Constructor method of Member class</h3>
     * this method creates an object of Member class.
     * @param memberId is an input String and should be <b>exactly 6</b> character.
     * @param name also is an input String.
     * @param address is an input String parameter.
     * @return nothing
     */
    public Member(String memberId, String name, Address address) {
        // The length of memberId must be exactly 6 characters.
        if (memberId.length() != 6){
            System.out.println("memberId must be 6 digits long");
            System.out.println("#####the construct process failed for member with id: " + memberId);
        }
        else if (address.getLicensePlate() == null){
            System.out.println("address cannot be null");
            System.out.println("#####the construct process failed for " + name + " member  with 'null' address.");
        }
        else {
            this.memberId = memberId;
            this.name = name;
            this.borrowedBooks = new ArrayList<>();
            this.address = address;
        }
    }
    /*
    Next we need to use getter and setter to apply the changes for private variables.
     */
    /** Getter method to get the value of numberId parameter.
     * @return String type. */
    public String getMemberId() {return memberId;}
    /** Getter method to get the value of name parameter.
     * @return String type. */
    public String getName() {return name;}
    /** Getter method to get the value of borrowedBooks parameter.
     * @return List type that members are an object from Book class. */
    public List<Book> getBorrowedBooks() {return borrowedBooks;}
    /** Getter method to get the value of address parameter.
     * @return object from Address class. */
    public Address getAddress() {return address;}
    /*
    Now we identify the Setter methods.
     */
    /** Setter method to change the value of memberId by considering that must be <b>exactly 6 characters</b>.
     * @param memberId is input value.
     * @return nothing*/
    public void setMemberId(String memberId) {
        if (memberId.length() == 6) this.memberId = memberId;       // The length of memberId must be exactly 6 characters.
        else{
            System.out.println("memberId must be 6 digits long");
            System.out.println("#####the construct process failed for member with id: " + memberId);
        }
    }
    /** Setter method to change the value of name.
     * @param newName is input value.
     * @return nothing*/
    public void setName(String newName) {this.name = newName;}
    /** This method <b>update or set</b> the value of address parameter that is an object from address class.
     * @param newAddress is input value.
     * @return nothing. */
    public void updateAddress(Address newAddress) {
        if (newAddress.getLicensePlate() != null) this.address = newAddress;
        else{
            System.out.println("address cannot be null");
            System.out.println("#####the change address process failed for " + name + " member with 'null' address.");
        }
    }
    /**
     * This method do the <b>borrowing process</b> for a member.<p>
     * We define many conditions to control the accuracy of process.
     * @param books is input value and the object with List type of Book class members that must be borrowed, we don't know have many they are.
     * @return nothing.
     */
    public void borrowBook(List<Book> books) {
        for (Book book : books) {
            if (book.getId() == null)   System.out.println("#####book cannot be null for member with '"+ name +"' name.");
            else if (borrowedBooks.contains(book))   System.out.println("#####That book with id '" + book.getId() + "' is already borrowed by " + name);
            else if (borrowedBooks.size() >= 3)      System.out.println("#####Member '"+ name +"' can't borrowed more than 3 books");
            else if (!book.getIsAvailable())        System.out.println("#####That book with id '" + book.getId() + "' is not available in the library");
            else {
                borrowedBooks.add(book);
                book.setIsAvailable(false);
                System.out.println("Book with id '" + book.getId() + "' Borrowed by " + name);
                //Track the number of borrowing book
                book.setTrackBorrowingTimes("Book with title '" + book.getTitle() + "' borrowed by Member with name '" + name + "' .");
            }
        }
    }
    /**
     * This method do the <b>returning process</b> for a member.
     * @param books is input value and the object with List type of Book class members that must be returned, we don't know have many they are.
     * @return nothing
     */
    public void returnBook(List<Book> books) {
        for (Book book : books) {
            if (!borrowedBooks.contains(book))   System.out.println("#####That book with id '" + book.getId() + "' is not borrowed by "+ name);
            else {
                borrowedBooks.remove(book);
                book.setIsAvailable(true);
                System.out.println("Book with id '" + book.getId() + "' returned by " +name);
            }
        }
    }
    /**
     * This method shows us the <b>information</b> of a member and print that in console.
     * @return nothing
     */
    public void printMemberInfo() {
        System.out.println("------Member ID: " + memberId);
        System.out.println("------Name: " + name);
        System.out.println("------Address => city: "+address.getCity()+", street: "+address.getStreet()+", licensePlate: "+address.getLicensePlate());
        System.out.println("------The borrowed books: ");
        for (Book book : borrowedBooks) {
            System.out.println(">>>Borrowed book with id '" + book.getId() + "' and its Title : " + book.getTitle());
        }if (borrowedBooks.isEmpty())   System.out.println(name+" don't borrowed any books.");
    }
}
