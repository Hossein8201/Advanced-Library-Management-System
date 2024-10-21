import java.util.*;
/**
 * <h1>Class for books and how them behave</h1>
 * In this class we define their attributes and properties.
 * <p>
 * @author Hossein Tatar - 40133014
 * @version 1.0
 * @since 2024-10-21
 */
public class Book {
    /*
    First we define the variables as follows:
    */
    /** <b>id</b> is a 5 character with String type. */
    private String id;
    /** <b>title</b> is a StringBuilder type, Because maybe we want to capitalize that.<P> */
    private StringBuilder title;
    /** <b>author</b> also is a String type. <P> */
    private String author;
    /** <b>isAvailable</b> is a boolean type that show the book exist in library or not. */
    private boolean isAvailable;
    /** <b>trackBorrowingTimes</b> is an array list to show the number of borrowing a book and track that. */
    private ArrayList<String> trackBorrowingTimes = new ArrayList<>();
    /** <b>genre</b> is an array list of <i>'Genre-enum-class'</i> type and shows the kinds.<p>
     * <u>note:</u> a book maybe contains multiple genre.*/
    private ArrayList<Genre> genres = new ArrayList<>();
    /** <b>borrowCount</b> is an int type that is <u>equals to</u> the number of members in <u>'trackBorrowingTimes'</u>. */
    private int borrowCount;
    /**
     * <h3>Constructor method of Book class</h3>
     * this method create an object of Book class.
     * @param id is an input String parameter and should be <b>exactly 5</b> character.
     * @param title is an input String.
     * @param author also is an input String.
     * @param genres is a single or multiple input of Genre class.
     * @return nothing
     */
    public Book(String id,String title, String author, Genre... genres) {
        // The length of id must be exactly 5 characters
        if (id.length() != 5){
            System.out.println("book id must be exactly 5 characters long");
            System.out.println("#####the construct process failed for book with id " + id);
        }
        else {
            this.id = id;
            this.title = new StringBuilder(title);
            this.author = author;
            this.isAvailable = true;        // Default is available
            this.genres.addAll(Arrays.asList(genres));      // Add members of genres to arraylist.
            this.borrowCount = 0;           // Initialized that number.
        }
    }
    /*
    Next we need to use getter and setter to apply the changes for private variables
    */
    /** Getter method to get the value of Id parameter.
     * @return String type that is id. */
    public String getId() {return id;}
    /** Getter method to get the value of Title parameter.
     * @return StringBuilder type that is title. */
    public StringBuilder getTitle() {return title;}
    /** Getter method to get the value of author parameter.
     * @return String type that is author. */
    public String getAuthor() {return author;}
    /** Getter method to get the value of Available boolean parameter.
     * @return boolean type that is isAvailable parameter. */
    public boolean getIsAvailable() {return isAvailable;}
    /** Getter method to get the value of tracking a book parameter.
     * @return an arraylist of String type. */
    public ArrayList<String> getTrackBorrowingTimes() { return trackBorrowingTimes; }
    /** Getter method to get the value of genres of a book parameter.
     * @return an arraylist of Genre class*/
    public ArrayList<Genre> getGenres() {return genres;}
    /** Getter method to get the value of borrow counting parameter.
     * @return an int type. */
    public int getBorrowCount() {return borrowCount;}
    /*
    Now we identify the Setter methods.
    */
    /** Setter method to change the value of id by considering that must be <b>exactly 5 characters</b>.
     * @param id is input variable.
     * @return nothing.*/
    public void setId(String id) {
        if(id.length() == 5)    this.id = id;         // The length of id must be exactly 5 characters
        else {
            System.out.println("book id must be exactly 5 characters long");
            System.out.println("#####the change id process failed for book with id " + id);
        }
    }
    /** Setter method to change the value of title.
     * @param title is input variable.
     * @return nothing.*/
    public void setTitle(String title) {this.title = new StringBuilder(title);}
    /** setter method to change the value of author.
     * @param author is input variable.
     * @return nothing.*/
    public void setAuthor(String author) {this.author = author;}
    /** setter method to change the value of isAvailable.
     * @param isAvailable is input variable.
     * @return nothing.*/
    public void setIsAvailable(boolean isAvailable) {this.isAvailable = isAvailable;}
    /** setter method to add a new path to trackBorrowingTimes. also plus one the borrow counting parameter.
     * @param trackBorrowingTimes is input variable.
     * @return nothing.*/
    public void setTrackBorrowingTimes(String trackBorrowingTimes) {this.trackBorrowingTimes.add(trackBorrowingTimes); borrowCount++;}
    /** setter method to change one or multiple values in genres.
     * @param genres is input variable that is ArrayList type.
     * @return nothing.*/
    public void setGenres(ArrayList<Genre> genres) {this.genres = genres;}
    /**
     * This method <b>capitalized</b> the letter in <b>begin of each words</b> in the title.<p>
     * To doing this function, we use from methods belong to StringBuilder type. It's better because we don't need to define other string.
     * so we can change that.
     * @return nothing
     */
    public void capitalizeTitle() {
        boolean isCapitalizable = true;     // Flag that shows the state of letter.
        for (int i = 0; i < title.length(); i++) {
            if (title.charAt(i) == ' ') isCapitalizable = true;
            else if (isCapitalizable){
                title.setCharAt(i, Character.toUpperCase(title.charAt(i)));     // Uppercase the letter next space.
                isCapitalizable = false;
            }
            else title.setCharAt(i, Character.toLowerCase(title.charAt(i)));   // Lowercase the rest of the word
        }
    }
    /**
     * This method shows us the <b>information</b> of a book and print that in console.
     * @return nothing
     */
    public void printBookInfo() {
        System.out.println("------Book ID: " + id);
        System.out.println("------Book Title: " + title.toString());
        System.out.println("------Book Author: " + author);
        System.out.print("------Book Genres: ");    for (Genre genre : genres) System.out.print(genre + " ");
        System.out.println("------Book available in library: " + isAvailable);
        System.out.println(">>>The number of borrowing Times is '" + borrowCount + "' times and it tracked path's are :");
        for (String i: trackBorrowingTimes) {
            System.out.println("------" + i);
        }
    }
}
