import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class ApplicationWindowController implements Initializable
{
    @FXML
    private Button enfi = new Button("enfi");
    @FXML
    private Button barn = new Button("barn");
    @FXML
    private Button hrgy = new Button("hrgy");
    @FXML
    private Button walt = new Button("walt");
    @FXML
    private Button hrrw = new Button("hrrw");
    @FXML
    private Button bren = new Button("bren");
    @FXML
    private Button camd = new Button("camd");
    @FXML
    private Button isli = new Button("isli");
    @FXML
    private Button hack = new Button("hack");
    @FXML
    private Button redb = new Button("redb");
    @FXML
    private Button have = new Button("have");
    @FXML
    private Button hill = new Button("hill");
    @FXML
    private Button eali = new Button("eali");
    @FXML
    private Button kens = new Button("kens");
    @FXML
    private Button wstm = new Button("wstm");
    @FXML
    private Button town = new Button("town");
    @FXML
    private Button newh = new Button("newh");
    @FXML
    private Button bark = new Button("bark");
    @FXML
    private Button houn = new Button("houn");
    @FXML
    private Button hamm = new Button("hamm");
    @FXML
    private Button wand = new Button("wand");
    @FXML
    private Button city = new Button("city");
    @FXML
    private Button gwch = new Button("gwch");
    @FXML
    private Button bexl = new Button("bexl");
    @FXML
    private Button rich = new Button("rich");
    @FXML
    private Button mert = new Button("mert");
    @FXML
    private Button lamb = new Button("lamb");
    @FXML
    private Button sthw = new Button("sthw");
    @FXML
    private Button lews = new Button("lews");
    @FXML
    private Button king = new Button("king");
    @FXML
    private Button sutt = new Button("sutt");
    @FXML
    private Button croy = new Button("croy");
    @FXML
    private Button brom = new Button("brom");
    
    
    private DataController dataController;
    private String area;
    
    private WelcomePanelController welcomePanelController;
    private static ArrayList<Button> myList;
    

    /**
     * 
     */
    public ApplicationWindowController() throws Exception
    {
        welcomePanelController = new WelcomePanelController();
        dataController = new DataController();
        //dataController.setColors();
        myList = new ArrayList<>();
    }
    
    /**
     * 
     */
    @Override
    @FXML
    public void initialize(URL url, ResourceBundle rb)
    {
        fillMyList();

        if (welcomePanelController.getStaticPriceLabelFrom() != null && welcomePanelController.getStaticPriceLabelTo() != null) {
            dataController.setColors();
        }
    }
    
    void setArea(String newArea)
    {
        area = newArea;
    }

    String getArea()
    {
        return area;
    }
    
    static void setColor(String borough, Paint color)
    {     
        
        for (Button area : myList) {
            if (String.valueOf(area).contains(borough) ) {
                area.setTextFill(color);
                //area.setStyle("-fx-background-color: #00ff00");
            }
        }
        
    }
    
    @FXML
    private void buttonClick(ActionEvent event) throws java.io.IOException
    {
        //if we jst print 
        //text = String.valueOf ( event.getSource());
        //System.out.println(text);
        // then Button[id=enfi, styleClass=button]'ENFI'
        // 10 and 14 - start and end index of the word we need
        HashMap<String, String> shortAreaNames = new HashMap<>() {{
                put("enfi", "Enfield");
                put("barn", "Barnet");
                put("hrgy", "Haringey");
                put("walt", "Waltham Forest");
                put("hrrw", "Harrow");
                put("bren", "Brent");
                put("camd", "Camden");
                put("isli", "Islington");
                put("hack", "Hackney");
                put("redb", "Redbridge");
                put("have", "Havering");
                put("hill", "Hillingdon");
                put("eali", "Ealing");
                put("kens", "Kensington and Chelsea");
                put("wstm", "Westminster");
                put("town", "Tower Hamlets");
                put("newh", "Newham");
                put("bark", "Barking and Dagenham");
                put("houn", "Hounslow");
                put("hamm", "Hammersmith and Fulham");
                put("wand", "Wandsworth");
                put("city", "City of London");
                put("gwch", "Greenwich");
                put("bexl", "Bexley");
                put("rich", "Richmond upon Thames");
                put("mert", "Merton");
                put("lamb", "Lambeth");
                put("sthw", "Southwark");
                put("lews", "Lewisham");
                put("king", "Kingston upon Thames");
                put("sutt", "Sutton");
                put("croy", "Croydon");
                put("brom", "Bromley");
        }};
        
        
        String shortAreaName = String.valueOf(event.getSource()).substring(10, 14);
        area = shortAreaName;
        
        Pane applicationStatistics = FXMLLoader.load(getClass().getResource("applicationStatistics.fxml"));
        MainApplication.addToTheVbox(applicationStatistics);
        
        Pane availablePropertiesWindow = FXMLLoader.load(getClass().getResource("availableProperties.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(availablePropertiesWindow);
        stage.setScene(scene);
        stage.setTitle(shortAreaNames.get(shortAreaName));
        stage.setResizable(false);
        stage.show();
        
    }
    
    private void fillMyList() {
            myList.add(enfi);
            myList.add(barn);
            myList.add(hrgy);
            myList.add(walt);
            myList.add(hrrw);
            myList.add(bren);
            myList.add(camd);
            myList.add(isli);
            myList.add(hack);
            myList.add(redb);
            myList.add(have);
            myList.add(hill);
            myList.add(eali);
            myList.add(kens);
            myList.add(wstm);
            myList.add(town);
            myList.add(newh);
            myList.add(bark);
            myList.add(houn);
            myList.add(hamm);
            myList.add(wand);
            myList.add(city);
            myList.add(gwch);
            myList.add(bexl);
            myList.add(rich);
            myList.add(mert);
            myList.add(lamb);
            myList.add(sthw);
            myList.add(lews);
            myList.add(king);
            myList.add(sutt);
            myList.add(croy);
            myList.add(brom);  
    }
}
