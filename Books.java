import java.util.HashMap;   // import the hashmap class
import ecs100.*;

/**
 * Holds collections of books in hashmap
 * Allows a user to add, find, print all, edit from a menu
 * Prevent user from adding a duplicate
 *
 * @author 13dtc
 * @version 27/5/21
 */
public class Books
{
    // instance variables - replace the example below with your own
    private HashMap<Integer, Book> booksMap;
    private int currBookId;

    /**
     * Constructor for objects of class Books
     */
    public Books()
    {
        // initialise instance variables
        booksMap = new HashMap<Integer, Book>();
        
        // creating books
        Book b1 = new Book(1, "Pet Semetary", "Stephen King", 76);
        Book b2 = new Book(2, "1984", "George Orwell", 66);
        Book b3 = new Book(3, "The Subtle Knife", "Phillip Pullman", 42);
        Book b4 = new Book(4, "Pet Semetary", "Stephen King", 76);
        Book b5 = new Book(5, "The Subtle Art of not Giving a F*ck", "Mark Mason", 99);
        
        // Add books to collection
        booksMap.put(1, b1);
        booksMap.put(2, b2);
        booksMap.put(3, b3);
        booksMap.put(4, b4);
        booksMap.put(5, b5);
        
        // initalise book ID
        this.currBookId = 4;
    }
    
    /**
     * Menu to print and call appropriate methods
     */
    public void menu() {
        // Print menu and force choice
        String choice;
        do {
            UI.println("(A)dd a book");
            UI.println("(F)ind a book");
            UI.println("(P)rint a book");
            UI.println("(Q)uit");
            
            choice = UI.askString("Enter a choice: ");
            
            if (choice.equalsIgnoreCase("A")) {
                addBook();
            } else if (choice.equalsIgnoreCase("F")) {
                findBook();
            } else if (choice.equalsIgnoreCase("P")) {
                printAll();
            } else if (choice.equalsIgnoreCase("Q")) {
                UI.println("Goodbye!");
                UI.quit();
            } else {
                UI.println("That is not a choice you knucklehead.");
            }
            
        } while (!choice.equalsIgnoreCase("Q"));
    }
    
    /**
     * Adds a book to the map
     */
    public void addBook() {
        
    }
    
    /**
     * Finds a book based on the id
     * Should refactor to find on name
     */
    public void findBook() {
        
    }
    
    /**
     * Prints details of all books
     */
    public void printAll() {
        for (int bookId : booksMap.keySet()) {
            UI.println(bookId + " Details: ");
            UI.println(booksMap.get(bookId).getName() + "  "
                        + booksMap.get(bookId).getAuthor() + "  "
                        + booksMap.get(bookId).getQuantity());
        }
    }
}
