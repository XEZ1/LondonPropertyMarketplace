import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class WelcomePanelController implements Initializable
{
    @FXML
    private Label priceLabelFrom;
    public static Label staticPriceLabelFrom;
    @FXML
    private Label priceLabelTo;
    public static Label staticPriceLabelTo;
    
    private DataController dataController;
    
    /**
     * 
     */
    public WelcomePanelController()
    {
        //dataController = new DataController();
        priceLabelFrom = new Label();
        priceLabelTo = new Label();
        
    }
    
    /**
     * 
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb)
    {
        staticPriceLabelFrom = priceLabelFrom;
        staticPriceLabelTo = priceLabelTo;
    }
    
    /**
     * 
     */
    void setStaticPriceLabelFrom(String text)
    {
        staticPriceLabelFrom.setText(text);
    }
    
    /**
     * 
     */
    Integer getStaticPriceLabelFrom()
    { 
        try {
            return Integer.valueOf((staticPriceLabelFrom.getText()));
        }
        catch (Exception e) {
            return null;
        }
        
    }
    
    /**
     * 
     */
    void setStaticPriceLabelTo(String text)
    {
        staticPriceLabelTo.setText(text);
    }
    
    /**
     * 
     */
    Integer getStaticPriceLabelTo()
    {
        try {
            return Integer.valueOf(staticPriceLabelTo.getText());
        }
        catch (Exception e) {
            return null;
        }
        
    }
}
