/**
 * <h1>A Class for a property of Members</h1>
 * In this class we want to organized the addresses and their attributes.
 * <p>
 * @author Hossein Tatar - 40133014
 * @version 1.0
 * @since 2024-10-21
 */
public class Address {
    /*
    First we define the variables as follows:
     */
    /** <b>city</b> is a String type. */
    private String city;
    /** <b>street</b> also is a string type. */
    private String street;
    /** <b>licensePlate</b> is a <u>5 character</u> String type. */
    private String licensePlate;
    /**
     * <h3>Constructor method of Address class</h3>
     * this method create an object of Address class.
     * @param city is an input String.
     * @param street also is an input String.
     * @param licensePlate is an input String parameter and should be <b>exactly 5</b> character.
     * @return nothing
     */
    public Address(String city, String street, String licensePlate) {
        // The length of licensePlate must be exactly 5 characters
        if (licensePlate.length() != 5){
            System.out.println("licensePlate of Address must be exactly 5 characters long");
            System.out.println("#####the construct process failed for Address with licensePlate " + licensePlate);
        }
        else{
            this.city = city;
            this.street = street;
            this.licensePlate = licensePlate;
        }
    }
    /*
    Next we need to use getter and setter to apply the changes for private variables
    */
    /** Getter method to get the value of city parameter.
     * @return String type. */
    public String getCity() {return city;}
    /** Getter method to get the value of street parameter.
     * @return String type. */
    public String getStreet() {return street;}
    /** Getter method to get the value of licensePlate parameter.
     * @return String type. */
    public String getLicensePlate() {return licensePlate;}
    /*
    Now we identify the Setter methods.
     */
    /** Setter method to change the value of city.
     * @param city is input value.
     * @return nothing*/
    public void setCity(String city) {this.city = city;}
    /** Setter method to change the value of street.
     * @param street is input value.
     * @return nothing*/
    public void setStreet(String street) {this.street = street;}
    /** Setter method to change the value of licensePlate by considering that must be <b>exactly 5 characters</b>.
     * @param licensePlate is input value.
     * @return nothing*/
    public void setLicensePlate(String licensePlate) {
        if (licensePlate.length() == 5) this.licensePlate = licensePlate;       // The length of licensePlate must be exactly 5 characters
        else{
            System.out.println("licensePlate of Address must be exactly 5 characters long");
            System.out.println("#####the change licensePlate process failed for Address with licensePlate " + licensePlate);
        }
    }
}
