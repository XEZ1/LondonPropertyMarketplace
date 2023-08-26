import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.fxml.*;
import java.net.URL;
import javafx.scene.control.*;
import java.util.List;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import java.util.ResourceBundle;

/**
 * Write a description of class ApplicationStatisticsController here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ApplicationStatisticsController implements Initializable
{
    private DataController dataController;
    
    /**
     * 
     */
    public ApplicationStatisticsController() throws Exception
    {
        dataController = new DataController();
    }
    
    /**
     * 
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }
}
