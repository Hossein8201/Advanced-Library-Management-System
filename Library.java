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
     * This method do the <b>adding book process</b> for a library.
     * @param bookArray is input value and the object with Array type of Book class members that must be added, we don't know have many they are.
     * @return nothing
     */
    public void addBook(Book... bookArray) {
        for (Book book : bookArray) {
            if (books.contains(book))   System.out.println("Book with id '" + book.getId() + "' is already exists in "+ name + " library.");
            else if (book.getId() == null)   System.out.println("Book does not identified.");
            else books.add(book);
        }
    }
    /**
     * This method do the <b>adding member process</b> for a library.
     * @param memberArray is input value and the object with Array type of Member class members that must be added, we don't know have many they are.
     * @return nothing
     */
    public void addMember(Member... memberArray) {
        for (Member member : memberArray) {
            if (members.contains(member))   System.out.println("Member with id '" + member.getMemberId() + "' is already exists in "+ name + " library.");
            else if (member.getMemberId() == null)   System.out.println("Member does not identified.");
            else members.add(member);
        }
    }
    /**
     * This method do the <b>borrowing process</b> for a member.
     * @param member is an object from Member class.
     * @param bookArray is input value and the object with Array type of Book class members that must be borrowed, we don't know have many they are.
     * @return nothing.
     */
    public void borrowBook(Member member, Book... bookArray) {
        if (!members.contains(member))
            System.out.println("#####Member with name '" + member.getName() + "' don't added to " + name + " library.");
        else {
            List<Book> borrowedBooks = new ArrayList<>();       // Create a List of book we can borrow that.
            for (Book book : bookArray) {
                if (!books.contains(book))
                    System.out.println("#####Book with id '" + book.getId() + "' don't belong to " + name + " library.");
                else    borrowedBooks.add(book);
            }
            member.borrowBook(borrowedBooks);
        }
    }
    /**
     * This method do the <b>returning process</b> for a member.
     * @param member is an object from Member class.
     * @param bookArray is input value and the object with Array type of Book class members that must be returned, we don't know have many they are.
     * @return nothing
     */
    public void returnBook(Member member, Book... bookArray) {
        if (!members.contains(member))
            System.out.println("#####Member with name '" + member.getName() + "' don't added to " + name + " library.");
        else {
            List<Book> returnedBooks = new ArrayList<>();       // Create a List of book we can return that.
            for (Book book : bookArray) {
                if (!books.contains(book))
                    System.out.println("#####Book with id '" + book.getId() + "' don't belong to " + name + " library.");
                else   returnedBooks.add(book);
            }
            member.returnBook(returnedBooks);
        }
    }

    /**
     * This method do the <b>searching and finding process</b> to give us the title of Books that was written by a specific author.
     * @param authorName is a String type, We based on search the author of Books.
     * @return a List of Strings that are the result of searching to find Books Written by authorName.
     */
    public List<String> findBooksByAuthor(String authorName) {
        List<String> bookWrittenByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (authorName.equalsIgnoreCase(book.getAuthor())){
                if (bookWrittenByAuthor.isEmpty())      bookWrittenByAuthor.add("----Books written by author '" + authorName + "': ");
                bookWrittenByAuthor.add(book.getTitle().toString());
            }
        } if (bookWrittenByAuthor.isEmpty()) bookWrittenByAuthor.add("Book that written by author '" + authorName + "' does not exist.");
        return bookWrittenByAuthor;
    }
    /**
     * This method do the <b>sorting process</b> based on Titles of collection of books.
     * <b>note:</b> We use of sort method in List type and customize that to sort books by titles. Then we add that to main variable.
     * @return nothing
     */
    public void sortBooksByTitle() {
        List<Book> sortedBooks = new ArrayList<>(books);        // First we convert the Collection type to List.
        sortedBooks.sort(new Comparator<>() {               // We sort that List.
            public int compare(Book book1, Book book2) {return book1.getTitle().compareTo(book2.getTitle());}
        });
        books.clear();      // We clear the books value.
        books.addAll(sortedBooks);      // In finish, we add the sorted List into the Collection.
    }
    /**
     * This method shows us the <b>information</b> of a library and print that in console.
     * @return nothing
     */
    public void printLibraryInfo() {
        System.out.println("----Name of library: " + name);
        System.out.println("----Books of " + name + " library: ");
        int numberIndex = 1;
        for (Book book : books) {
            System.out.println(">>>Book '" + numberIndex++ + "' :");
            book.printBookInfo();
        }if (books.isEmpty()) System.out.println("Don't exist any books in " + name + " library.");
        System.out.println("----Members of " + name + " library: ");
        numberIndex = 1;
        for (Member member : members) {
            System.out.println(">>>Member '" + numberIndex++ + "' :");
            member.printMemberInfo();
        }if (members.isEmpty()) System.out.println("Don't exist any members in " + name + " library.");
    }
}
