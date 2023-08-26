import javafx.application.Application;
import java.util.List;
import java.util.ArrayList;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import javafx.scene.layout.Pane;
import javafx.fxml.*;
import java.util.ResourceBundle;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 * This is a class that should be invokked to start the application.
 * It draws the first template and initializes it.
 * Also this class provides implementation for all the buttons / choice boxes 
 * included in MainApplication.fxml
 *
 * @author Ezzat Alsalibi
 * @version 3.2.5
 */
public class MainApplication extends Application
{    
    protected static Pane root; 
    protected static List<Pane> vbox = new ArrayList<>(); // list of border panes to mve between them
    protected BorderPane applicationWindow; 
    protected BorderPane applicationStatistics;
    protected BorderPane welcomePanel;

    // Delete these later
    protected BorderPane check1;
    protected BorderPane check2;
    protected BorderPane check3;
    
    
    /**
     * 
     */
    public MainApplication() throws Exception
    {   
        welcomePanel = FXMLLoader.load(getClass().getResource("WelcomePanel.fxml"));
    }
    
    /**
     * Basic overriden "start" method.
     * Basically it initialises the main window and adds other preloaded windows
     * to the list that is used to move between them.
     * 
     * @throw input / output exceptions because getClass() is used.
     */
    @Override
    public void start(Stage stage) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("MainApplication.fxml"));
        
        vbox.add(welcomePanel);
      
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Main Application's window");
        stage.setScene(scene);
        stage.show();
 
    }

    static List<Pane> getVbox()
    {
        return vbox;
    }
    
    static void addToTheVbox(Pane window)
    {
        vbox.add(window);
    }
    
    static void deleteFromTheVbox(Pane window)
    {
        vbox.remove(window);
    }
    
    void deleteEverythingFromTheVbox()
    {
        for (Pane item : vbox) {
            if (item == welcomePanel) {
                //skip
            }
            else {
                vbox.remove(item);
            }
        }

    }
}
