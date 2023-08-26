import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataController
{
    private AirbnbDataLoader data;
    private ArrayList<AirbnbListing> listOfProperties; // loaded list of all properties
    private int min; // minimum price value in the CSV file
    private int max; // maximum price value in the CSV file  
    private int amountOfLinesInCBs; //amount of lines in any choice box
    private int valueToAdd; // value that has to be added to a choice box
    private int difference; // value needed to count the prices in a choice box
    private ObservableList<Integer> pricesFrom;
    private ObservableList<Integer> pricesTo;    
    
    // available properties
    private int propertiesAvailableInEnfi;
    private int propertiesAvailableInBarn;
    private int propertiesAvailableInHrgy;
    private int propertiesAvailableInWalt;
    private int propertiesAvailableInHrrw;
    private int propertiesAvailableInBren;
    private int propertiesAvailableInCamd;
    private int propertiesAvailableInIsli;
    private int propertiesAvailableInHack;
    private int propertiesAvailableInRedb;
    private int propertiesAvailableInHave;
    private int propertiesAvailableInHill;
    private int propertiesAvailableInEali;
    private int propertiesAvailableInKens;
    private int propertiesAvailableInWstm;
    private int propertiesAvailableInTown;
    private int propertiesAvailableInNewh;
    private int propertiesAvailableInBark;
    private int propertiesAvailableInHoun;
    private int propertiesAvailableInHamm;
    private int propertiesAvailableInWand;
    private int propertiesAvailableInCity;
    private int propertiesAvailableInGwch;
    private int propertiesAvailableInBexl;
    private int propertiesAvailableInRich;
    private int propertiesAvailableInMert;
    private int propertiesAvailableInLamb;
    private int propertiesAvailableInSthw;
    private int propertiesAvailableInLews;
    private int propertiesAvailableInKing;
    private int propertiesAvailableInSutt;
    private int propertiesAvailableInCroy;
    private int propertiesAvailableInBrom;
    
    //-------------------------------------
    //properties selected in window 1, 2:
    private int priceSelectedLow;
    private int priceSelectedHigh;
    private String borrowSelected;

    //classes 
    private WelcomePanelController welcomePanelController;
    private ApplicationWindowController applicationWindowController;
    
    private int pressed;
    /**
     * Constructor for objects of class DataController
     */
    public DataController()
    {
        
        //---
        //welcomePanelController = new WelcomePanelController();
        //applicationWindowController = new ApplicationWindowController();
        pressed = 0;
        
        min = 0;
        max = 0;
        data = new AirbnbDataLoader();
        listOfProperties = data.load();
        valueToAdd = 0;
        difference = 0;
        amountOfLinesInCBs = 7;
        pricesFrom = FXCollections.observableArrayList();
        pricesTo = FXCollections.observableArrayList();
        welcomePanelController = new WelcomePanelController();
    }
    
    ObservableList<Integer> getPriceListFrom()
    {
        return pricesFrom;
    }
    
    void setPriceListFrom(ObservableList<Integer> list)
    {
        this.pricesFrom = list;
    }
    
    ObservableList<Integer> getPriceListTo()
    {
        return pricesTo;
    }
    
    void setPriceListTo(ObservableList<Integer> list)
    {
        this.pricesTo = list;
    }
    
    /**
     * Helper method that finds minimum and maximum values from the loaded CSV file.
     */
    private void findMinMaxValues()
    {
        for (AirbnbListing property : listOfProperties) {
            if (property.getPrice() < min) {
                min = property.getPrice();
            }
            
            if (property.getPrice() > max) {
                max = property.getPrice();
            }    
        }
    }
    
    /**
     * Helper method that fills the choice box with prices
     * 
     * @return observable list full of values to be put in a choice box
     */
    ObservableList priceFromList()
    {
        findMinMaxValues();
        pricesFrom.add(min);
        
        max /= (int) 2;
        difference = max / amountOfLinesInCBs;
        for (int i = 1; i <= amountOfLinesInCBs - 1; i++) {
            valueToAdd += difference;
            pricesFrom.add(valueToAdd);
        }
        
        pricesFrom.add(max);
        return pricesFrom;
    }
    
    /**
     * Helper method that fills the choice box with prices
     * 
     * @return observable list full of values to be put in a choice box
     */
    ObservableList priceToList()
    {
        min = max;
        valueToAdd = max;
        max *= 2;
        pricesTo.add(min);
        for (int i = 1; i <= amountOfLinesInCBs - 1; i++) {
            valueToAdd += difference;
            pricesTo.add(valueToAdd);
        }
        
        pricesTo.add(max);
        return pricesTo;
    }
    
    
    void loadAvailablePropertiesData()
    {
        
        priceSelectedLow = welcomePanelController.getStaticPriceLabelFrom();
        priceSelectedHigh = welcomePanelController.getStaticPriceLabelTo();
        
        for (AirbnbListing property : listOfProperties) {
            
            int priceCurrent = property.getPrice();
            String currentArea = property.getNeighbourhood();
            
            if (priceCurrent >= priceSelectedLow && priceCurrent <= priceSelectedHigh) {           
                if (currentArea.equals("Enfield")) {
                    propertiesAvailableInEnfi += 1;
                }
                if (currentArea.equals("Barnet")) {
                    propertiesAvailableInBarn += 1;
                }
                if (currentArea.equals("Haringey")) {
                    propertiesAvailableInHrgy += 1;
                }
                if (currentArea.equals("Waltham Forest")) {
                    propertiesAvailableInWalt += 1;
                }
                if (currentArea.equals("Harrow")) {
                    propertiesAvailableInHrrw += 1;
                }
                if (currentArea.equals("Brent")) {
                    propertiesAvailableInBren += 1;
                }
                if (currentArea.equals("Camden")) {
                    propertiesAvailableInCamd += 1;
                }
                if (currentArea.equals("Islington")) {
                    propertiesAvailableInIsli += 1;
                }
                if (currentArea.equals("Hackney")) {
                    propertiesAvailableInHack += 1;
                }
                if (currentArea.equals("Redbridge")) {
                    propertiesAvailableInRedb += 1;
                }
                if (currentArea.equals("Havering")) {
                    propertiesAvailableInHave += 1;
                }
                if (currentArea.equals("Hillingdon")) {
                    propertiesAvailableInHill += 1;
                }
                if (currentArea.equals("Ealing")) {
                    propertiesAvailableInEali += 1;
                }
                if (currentArea.equals("Kensington and Chelsea")) {
                    propertiesAvailableInKens += 1;
                }
                if (currentArea.equals("Westminster")) {
                    propertiesAvailableInWstm += 1;
                }
                if (currentArea.equals("Tower Hamlets")) {
                    propertiesAvailableInTown += 1;
                }
                if (currentArea.equals("Newham")) {
                    propertiesAvailableInNewh += 1;
                }
                if (currentArea.equals("Barking and Dagenham")) {
                    propertiesAvailableInBark += 1;
                }
                if (currentArea.equals("Hounslow")) {
                    propertiesAvailableInHoun += 1;
                }
                if (currentArea.equals("Hammersmith and Fulham")) {
                    propertiesAvailableInHamm += 1;
                }
                if (currentArea.equals("Wandsworth")) {
                    propertiesAvailableInWand += 1;
                }
                if (currentArea.equals("City of London")) {
                    propertiesAvailableInCity += 1;
                }
                if (currentArea.equals("Greenwich")) {
                    propertiesAvailableInGwch += 1;
                }
                if (currentArea.equals("Bexley")) {
                    propertiesAvailableInBexl += 1;
                }
                if (currentArea.equals("Richmond upon Thames")) {
                    propertiesAvailableInRich += 1;
                }
                if (currentArea.equals("Merton")) {
                    propertiesAvailableInMert += 1;
                }
                if (currentArea.equals("Lambeth")) {
                    propertiesAvailableInLamb += 1;
                }
                if (currentArea.equals("Southwark")) {
                    propertiesAvailableInSthw += 1;
                }
                if (currentArea.equals("Lewisham")) {
                    propertiesAvailableInLews += 1;
                }
                if (currentArea.equals("Kingston upon Thames")) {
                    propertiesAvailableInKing += 1;
                }
                if (currentArea.equals("Sutton")) {
                    propertiesAvailableInSutt += 1;
                }
                if (currentArea.equals("Croydon")) {
                    propertiesAvailableInCroy += 1;
                }
                if (currentArea.equals("Bromley")) {
                    propertiesAvailableInBrom += 1;
                }
            } 
        }
    }
    
    
    void setColors()
    {
        if (pressed == 0) {
            loadAvailablePropertiesData();
        
            HashMap<String, Integer> listOfSpecificAvailableProperties = new HashMap<>();
            listOfSpecificAvailableProperties.put("enfi", propertiesAvailableInEnfi);
            listOfSpecificAvailableProperties.put("barn", propertiesAvailableInBarn);
            listOfSpecificAvailableProperties.put("hrgy", propertiesAvailableInHrgy);
            listOfSpecificAvailableProperties.put("walt", propertiesAvailableInWalt);
            listOfSpecificAvailableProperties.put("hrrw", propertiesAvailableInHrrw);
            listOfSpecificAvailableProperties.put("bren", propertiesAvailableInBren);
            listOfSpecificAvailableProperties.put("camd", propertiesAvailableInCamd);
            listOfSpecificAvailableProperties.put("isli", propertiesAvailableInIsli);
            listOfSpecificAvailableProperties.put("hack", propertiesAvailableInHack);
            listOfSpecificAvailableProperties.put("redb", propertiesAvailableInRedb);
            listOfSpecificAvailableProperties.put("have", propertiesAvailableInHave);
            listOfSpecificAvailableProperties.put("hill", propertiesAvailableInHill);
            listOfSpecificAvailableProperties.put("eali", propertiesAvailableInEali);
            listOfSpecificAvailableProperties.put("kens", propertiesAvailableInKens);
            listOfSpecificAvailableProperties.put("wstm", propertiesAvailableInWstm);
            listOfSpecificAvailableProperties.put("town", propertiesAvailableInTown);
            listOfSpecificAvailableProperties.put("newh", propertiesAvailableInNewh);
            listOfSpecificAvailableProperties.put("bark", propertiesAvailableInBark);
            listOfSpecificAvailableProperties.put("houn", propertiesAvailableInHoun);
            listOfSpecificAvailableProperties.put("hamm", propertiesAvailableInHamm);
            listOfSpecificAvailableProperties.put("wand", propertiesAvailableInWand);
            listOfSpecificAvailableProperties.put("city", propertiesAvailableInCity);
            listOfSpecificAvailableProperties.put("gwch", propertiesAvailableInGwch);
            listOfSpecificAvailableProperties.put("bexl", propertiesAvailableInBexl);
            listOfSpecificAvailableProperties.put("rich", propertiesAvailableInRich);
            listOfSpecificAvailableProperties.put("mert", propertiesAvailableInMert);
            listOfSpecificAvailableProperties.put("lamb", propertiesAvailableInLamb);
            listOfSpecificAvailableProperties.put("sthw", propertiesAvailableInSthw);
            listOfSpecificAvailableProperties.put("lews", propertiesAvailableInLews);
            listOfSpecificAvailableProperties.put("king", propertiesAvailableInKing);
            listOfSpecificAvailableProperties.put("sutt", propertiesAvailableInSutt);
            listOfSpecificAvailableProperties.put("croy", propertiesAvailableInCroy);
            listOfSpecificAvailableProperties.put("brom", propertiesAvailableInBrom);
    
        
        
        
            for (Map.Entry<String, Integer> area: listOfSpecificAvailableProperties.entrySet()) {
    
                if (area.getValue() <= 100) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(252, 3, 3));
                }
                else if (area.getValue() > 100 && area.getValue() <= 500) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(252, 3, 50));
                }
                else if (area.getValue() > 500 && area.getValue() <= 1000) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(252, 3, 80));
                }
                else if (area.getValue() > 1000 && area.getValue() <= 1500) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(220, 252, 3));
                }
                else if (area.getValue() > 1500 && area.getValue() <= 2000) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(207, 252, 3));
                } 
                else if (area.getValue() > 2000 && area.getValue() <= 2500) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(194, 252, 3));
                }
                else if (area.getValue() > 2500 && area.getValue() <= 3000) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(252, 3, 80));
                }
                else if (area.getValue() > 3000 && area.getValue() <= 4000) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(3, 252, 160));
                }
                else if (area.getValue() > 4000 && area.getValue() <= 5000) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(3, 252, 145));
                }
                else if (area.getValue() > 5000 && area.getValue() <= 6000) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(3, 252, 130));
                }   
                else if (area.getValue() > 6000 && area.getValue() <= 7000) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(3, 252, 120));
                }
                else if (area.getValue() > 7000 && area.getValue() <= 8000) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(3, 252, 110));
                }
                else if (area.getValue() > 8000 && area.getValue() <= 9000) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(3, 252, 94));
                }
                else if (area.getValue() > 9000 && area.getValue() <= 10000) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(3, 252, 78));
                }
                else if (area.getValue() > 10000 && area.getValue() <= 11000) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(3, 252, 69));
                }
                else if (area.getValue() > 11000 && area.getValue() <= 12000) {
                    ApplicationWindowController.setColor(area.getKey(), Color.rgb(3, 252, 53));
                }     
            }
            
            pressed++;
        }
        else {
            //skip
        }
    }

    ArrayList<String[]> getListTheProperties()
    {
        ArrayList<String[]> list = new ArrayList<String[]>();
        
        for (AirbnbListing property : listOfProperties) {
            list.add(new String[] {property.getHost_name(), String.valueOf(property.getPrice()), String.valueOf(property.getNumberOfReviews()), String.valueOf(property.getMinimumNights()) } );
        }
        return list;
    }
}
