import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is a class that should be invokked to start the application.
 * It draws the first template and initializes it.
 * Also this class provides implementation for all the buttons / choice boxes 
 * included in MainApplication.fxml
 *
 * @author Ezzat Alsalibi
 * @version 3.2.5
 */
public class MainApplicationController extends MainApplication implements Initializable
{
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private Button backButton;
    @FXML
    private Button forwardButton;
    @FXML
    private ChoiceBox choiceBoxFrom;
    @FXML
    private ChoiceBox choiceBoxTo;
    
    private int pageIndex; // index of the current page
    private DataController dataController;
    private WelcomePanelController welcomePanelToChangeValues;
    
    
    // Delete these later
    private BorderPane check1;
    private BorderPane check2;
    private BorderPane check3;
    private ApplicationWindowController applicationWindowController;
    
    private int forwardPressed;
    private boolean applicationWindowIsNotAdded;
    
    /**
     * 
     */
    public MainApplicationController() throws Exception
    {
        applicationWindowIsNotAdded = true;
        pageIndex = 0;
        forwardPressed = 0;
        dataController = new DataController();
        welcomePanelToChangeValues = new WelcomePanelController();
        applicationWindowController = new ApplicationWindowController();
    }
    
    /**
     * Control method.
     * Overriden "initialize". Used to set choice boxes' items.
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb)
    {
        mainBorderPane.setCenter(welcomePanel);
        choiceBoxFrom.setItems(dataController.priceFromList());
        choiceBoxTo.setItems(dataController.priceToList());
        makeButtonsAvailable();
    }
    
    /**
     * The method adds a listener to the both choice boxes and observale variables. 
     * If the value in the first box was picked then the back button will be abled.
     * If the value in the second box was picked then the forward button will be abled. 
     * Buttons still not going to work until values picked in both choice boxes (see the
     * implementations of buttonClickBack and buttonClickForward methods).
     */
    private void makeButtonsAvailable()
    {
        choiceBoxFrom.getSelectionModel().selectedIndexProperty().addListener
        ((ov, oldValue, newValue) -> 
        { 
            backButton.setDisable(false); 
            choiceBoxFrom.setDisable(true);
            
            try
            {
                printValue1ToTheWelcomePanel(newValue);
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            
        });
        
        choiceBoxTo.getSelectionModel().selectedIndexProperty().addListener
        ((ov, oldValue, newValue) -> 
        {
            forwardButton.setDisable(false); 
            choiceBoxTo.setDisable(true);
            
            try
            {
                printValue2ToTheWelcomePanel(newValue);
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
            
        });
    }
    
    /**
     * 
     */
    private void printValue1ToTheWelcomePanel(Number newValue) throws IOException
    {
        String valueToPut = String.valueOf((dataController.getPriceListFrom()).get((int) newValue));
        welcomePanelToChangeValues.setStaticPriceLabelFrom(valueToPut);
    }
    
    /**
     * 
     */
    private void printValue2ToTheWelcomePanel(Number newValue) throws IOException
    {
        String valueToPut = String.valueOf((dataController.getPriceListTo()).get((int) newValue));
        welcomePanelToChangeValues.setStaticPriceLabelTo(valueToPut);
    }
    
    /**
     * Back button's implementation.
     */
    @FXML
    private void buttonClickBack(ActionEvent event)
    {
        if (backButton.isDisable() || forwardButton.isDisable()) {
            System.out.println("Please select a price range in both choice boxes");
        }
        else {
            if (pageIndex == 0 && applicationWindowIsNotAdded) {
                System.out.println("You can not go back here!");
            }
            else if (pageIndex > 0 && pageIndex <= vbox.size() - 1) {
                pageIndex -= 1;
                mainBorderPane.setCenter(vbox.get(pageIndex));
            }
            else { 
                pageIndex = vbox.size() - 1;
                mainBorderPane.setCenter(vbox.get(pageIndex));
            }
        }
    }

    /**
     * Forward button's implementation.
     */
    @FXML
    private void buttonClickForward(ActionEvent event)
    {   
        if (backButton.isDisable() || forwardButton.isDisable()) {
            System.out.println("Please select a price range in both choice boxes");
        }
        else {
            if (pageIndex == 0) {
                if (applicationWindowIsNotAdded) {
                    addApplicationWindow();
                    applicationWindowIsNotAdded = false;
                }
                pageIndex += 1;
                mainBorderPane.setCenter(vbox.get(pageIndex));            }
            else if (pageIndex >= 0 && pageIndex < vbox.size() - 1) {
                
                pageIndex += 1;
                mainBorderPane.setCenter(vbox.get(pageIndex));
            }
            else { 
                pageIndex = 0;
                mainBorderPane.setCenter(vbox.get(pageIndex));
            }
        }
    }
    
    private void addApplicationWindow() 
    {
        try
        {
            //deleteEverythingFromTheVbox();
            applicationWindow = FXMLLoader.load(getClass().getResource("ApplicationWindow.fxml"));
            vbox.add(applicationWindow);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        
    }
}
