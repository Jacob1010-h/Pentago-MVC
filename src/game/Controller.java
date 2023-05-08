package game;
import com.mrjaffesclass.apcs.messenger.*;

/**
 *
 * The Controller is the master of the App you're writing. It instantiates the
 * view and the model, receives messages from the View in response to user
 * interface (UI) actions like clicking a button, changing an input field,
 * etc.  It also sends and receives messages to the Model to commuincate
 * changes required and changes made to the Model variables.
 *
 * @author Roger Jaffe
 * @version 1.0
 */
public class Controller implements MessageHandler {

    /**
     * Program entry -- main is called when the program starts
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller app = new Controller();  // Create our controller...

    }

    @Override
    public void messageHandler(String s, Object o) {

    }
}