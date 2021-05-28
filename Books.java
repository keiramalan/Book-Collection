import java.util.HashMap;   // import the hashmap class
import ecs100.*;
import java.awt.Color;

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
        
        //this.menu();
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
            UI.println("(P)rint books");
            UI.println("(Q)uit");
            
            choice = UI.askString("Enter a choice: ");
            
            if (choice.equalsIgnoreCase("A")) {
                addBook();
            //} else if (choice.equalsIgnoreCase("F")) {
            //    findBook();
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
        final int MAX_QUANTITY = 99;
        int quantity = -1;
        
        // Ask user for details
        String name = UI.askString("Title: ");
        String author = UI.askString("Author: ");
        
        // check boundaries for the num of books added to stock
        do {
            quantity = UI.askInt("Quantity: ");
        } while (0 > quantity || quantity > MAX_QUANTITY);
        
        // add a boook image for display in GUI
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        // Increment book id counter and add book to hashmap
        currBookId++;
        booksMap.put(currBookId, new Book(currBookId, name, author, quantity, imgFileName));
    }
    
    /**
     * Finds a book based on the id
     * Should refactor to find on name
     */
    public void findBook(String bookName) {

        int bookId = -1;
        for (int tryBookId = 1; tryBookId <= booksMap.size(); tryBookId++) {
            if (booksMap.get(tryBookId).getName().equalsIgnoreCase(bookName))
                bookId = tryBookId;
        }
        
        if (bookId > 0) {
            UI.println(booksMap.get(bookId).getName()); // prints book name
            UI.println("By: " + booksMap.get(bookId).getAuthor()); // prints book author
            booksMap.get(bookId).displayBook(); // shows book cover on canvas
        } else {
            UI.println("No matching title found.");
        }
    }
    
    /**
     * Prints details of all books
     */
    public void printAll() {
        UI.setFontSize(20);
        UI.setColor(Color.blue);
        // change y position 
        int pos = 50;
        // array which holds color 
        int[] colorNum = new int[3];
        colorNum[0] = 0;
        colorNum[1] = 0;
        colorNum[2] = 0;
        int colorCounter = 0;

        
        for (int bookId : booksMap.keySet()) {
            
            // create color
            Color col = new Color(colorNum[0], colorNum[1], colorNum[2]);
            // change color
            UI.setColor(col);
            
            UI.drawString(bookId + " Details: ", 100, (pos));
            UI.drawString(booksMap.get(bookId).getName(), 100, (pos+30));
            UI.drawString(booksMap.get(bookId).getAuthor(), 100, (pos+50));
            pos += 80;
            
            // change red blue green
            // add to colorcounter if colorcounter is less than 3
            // otherwise reset
            if (colorCounter >= 2) {
                colorCounter = 0;
            } else {
                colorCounter += 1;
            }
            
            // change number in array where colorcounter is
            // unless surpassed 255, in which case go back to zero
            if (colorNum[colorCounter] + 30 < 255) {
                colorNum[colorCounter] += 30;
            } else {
                colorNum[colorCounter] = 0;
            }
            
            //UI.drawString(booksMap.get(bookId).getQuantity(), 100, 350);
        }
    }
    
}
