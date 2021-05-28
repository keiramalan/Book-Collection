import ecs100.*;
/**
 * GUI functionality
 *
 * @author Keira Malan
 * @version 28/5/21
 */
public class GUI
{
    // methods
    
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        Books bk = new Books();
        UI.initialise();
        UI.addButton("Print All", bk::printAll);
        UI.addTextField("Find Book", bk::findBook);
        UI.addButton("Add Book", bk::addBook);
        UI.addButton("Quit", UI::quit);
    }

}
