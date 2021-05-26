
/**
 * Book contains an id, name, author, quantity, image
 * @author 13dtc
 * @version May 2021
 */

public class Book
{
    // fields
    private int id;
    private String author;
    private String name;
    private int quantity;
    private String image;
    
    public Book(int id, String nm, String auth, int qty) {
        // intialise instance variables
        this.id = id;
        this.name = nm;
        this.author = auth;
        this.quantity = qty;
    }
    
    /**
     * Getter for ID
     * @return int the id
     */
    public int getId() {
         return this.id;
    }
    
    /**
     * Getter for name
     * @return string the name
     */
    public String getName() {
         return this.name;
    }
    
    /**
     * Getter for author
     * @return string the author
     */
    public String getAuthor() {
         return this.author;
    }
    
    /**
     * Getter for ID
     * @return int the id
     */
    public int getQuantity() {
         return this.quantity;
    }
}
