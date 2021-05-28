import ecs100.*;
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
    private static final String DEFAULT_IMAGE = "borzoi.jpg";
    private double locX, locY;
    
    public Book(int id, String nm, String auth, int qty, String img) {
        // intialise instance variables
        this.id = id;
        this.name = nm;
        this.author = auth;
        this.quantity = qty;
        this.image = img;
    }
    
    /**
     * Constructor overloading
     * Set default image 
     * Pulls info from other method and adds deafult image
     */
    public Book(int id, String nm, String author, int qty) {
        this(id, nm, author, qty, DEFAULT_IMAGE);
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
     * Getter for Quantity
     * @return int the quantity
     */
    public int getQuantity() {
         return this.quantity;
    }
    
    /**
     * Display image on our GUI
     */
    public void displayBook() {
        locX = 100;
        locY = 100;
        final double WIDTH = 200;
        final double HEIGHT = 200;
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
}
