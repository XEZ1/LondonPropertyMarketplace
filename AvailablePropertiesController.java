import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class AvailablePropertiesController implements Initializable
{
    @FXML
    private ChoiceBox choiceBoxSortBy;
    @FXML
    private TableView<Property> tableView;
    @FXML
    private TableColumn<Property, String> columnHost;
    @FXML
    private TableColumn<Property, Integer> columnPrice;
    @FXML
    private TableColumn<Property, Integer> columnNumOfReviews;
    @FXML
    private TableColumn<Property, Integer> columnMinNights;
    
    private DataController dataController;
    private ObservableList<String> sortingOptions;
    
    /**
     * Constructor for objects of class AvailableProperiesWindow
     */
    public AvailablePropertiesController()
    {
        dataController = new DataController();
        sortingOptions = FXCollections.observableArrayList();
        fillSortingOptions();
    }
    
    /**
     * 
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb)
    {        
        choiceBoxSortBy.setItems(sortingOptions);
        
        columnHost.setCellValueFactory(new PropertyValueFactory<>("host"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        columnNumOfReviews.setCellValueFactory(new PropertyValueFactory<>("numberOfReviews"));
        columnMinNights.setCellValueFactory(new PropertyValueFactory<>("minNights"));
    
        fillTheTable();
    }
    
    private void fillSortingOptions()
    {
        sortingOptions.add("Alphabetically");
        sortingOptions.add("by host name");
        sortingOptions.add("by price");
        sortingOptions.add("by number of reviews");
    }

    private void fillTheTable()
    {
        //tableView.getItems().addAll(dataController.getListTheProperties());
        for (String[] property : dataController.getListTheProperties()) {
            tableView.getItems().add(new Property(property[0], Integer.valueOf(property[1]), Integer.valueOf(property[2]), Integer.valueOf(property[3]) ));
            //tableView.getItems().add(new Property(property[0], Integer.valueOf(property[1]), Integer.valueOf(property[2]), Integer.valueOf(property[3]) ));
            //tableView.setItems( FXCollections.observableArrayList(new Property(property[0], Integer.valueOf(property[1]), Integer.valueOf(property[2]), Integer.valueOf(property[3]) )));
            //tableView.setItems( FXCollections.observableArrayList(new Property(property[0], Integer.valueOf(property[1]), Integer.valueOf(property[2]), Integer.valueOf(property[3]) )));
        }
    }
    
}
