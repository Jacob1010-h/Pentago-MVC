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
public class Controller implements MessageHandler{

    Messenger mvcMessaging;
    public Controller() {
        this.mvcMessaging = new Messenger();

        GamePanel gp = new GamePanel(mvcMessaging);

        Model model = new Model(mvcMessaging);

    }

    public void init() {
        // subscribe to messages from the view (UI)
//        mvcMessaging.subscribe("", this);
    }


    /**
     * Program entry -- main is called when the program starts
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller app = new Controller();  // Create our controller...
        app.init();
    }

    @Override
    public void messageHandler(String messageString, Object messageObject) {
        if (messageObject != null) {
            System.out.println("MSG: received by controller: "+messageString+" | "+messageObject.toString());
        } else {
            System.out.println("MSG: received by controller: "+messageString+" | No data sent");
        }
        // TODO: Add message handling code for messages received from the GamePanel
    }
}