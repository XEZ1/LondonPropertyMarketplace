import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Property
{
    private SimpleStringProperty host;
    private SimpleIntegerProperty price;
    private SimpleIntegerProperty numberOfReviews;
    private SimpleIntegerProperty minNights;
    
    /**
     * Constructor for objects of class Properties
     */
    public Property(String propertyName, Integer propertyPrice, Integer propertyNumOfReviews, Integer propertyMinNights)
    {
        this.host = new SimpleStringProperty(propertyName);
        this.price = new SimpleIntegerProperty(propertyPrice);
        this.numberOfReviews = new SimpleIntegerProperty(propertyNumOfReviews);
        this.minNights = new SimpleIntegerProperty(propertyMinNights);
    }
    
    public String getHost()
    {
        return host.get();
    }
    
    public int getPrice()
    {
        return price.get();
    }
    
    public int getNumberOfReviews()
    {
        return numberOfReviews.get();
    }
    
    public int getMinNights()
    {
        return minNights.get();
    }
}
