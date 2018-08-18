// Generated with g9.

package it.f12.stockprediction.entity.orm;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="quote")
public class Quote implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3702817019385582527L;

	/** Primary key. */
    protected static final String PK = "id";

    @Id
    @Column(unique=true, nullable=false, length=10)
    @GeneratedValue(strategy = javax.persistence.GenerationType.AUTO )
    private int id;
    @Column(name="date_of_quote")
    private Date dateOfQuote;
    @Column(precision=22)
    private Double value;
    @Column(name="max_value", precision=22)
    private double maxValue;
    @Column(name="min_value", precision=22)
    private double minValue;
    @Column(name="open_value", precision=22)
    private double openValue;
    @Column(precision=22)
    private double volume;
    
    
    
    @OneToMany(mappedBy="quote")
    private Set<Position> position;
    @OneToMany(mappedBy="quote")
    private Set<QuoteIndicator> quoteIndicator;
    @OneToMany(mappedBy="quote")
    private Set<QuoteShift> quoteShift;
    @ManyToOne(optional=false)
    @JoinColumn(name="stock", nullable=false)
    private Stock stock;
    @ManyToOne(optional=false)
    @JoinColumn(name="timeframe", nullable=false)
    private Timeframe timeframe;

    /** Default constructor. */
    public Quote() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }





    /**
     * Access method for maxValue.
     *
     * @return the current value of maxValue
     */
    public double getMaxValue() {
        return maxValue;
    }

    /**
     * Setter method for maxValue.
     *
     * @param aMaxValue the new value for maxValue
     */
    public void setMaxValue(double aMaxValue) {
        maxValue = aMaxValue;
    }

    /**
     * Access method for minValue.
     *
     * @return the current value of minValue
     */
    public double getMinValue() {
        return minValue;
    }

    /**
     * Setter method for minValue.
     *
     * @param aMinValue the new value for minValue
     */
    public void setMinValue(double aMinValue) {
        minValue = aMinValue;
    }

    /**
     * Access method for openValue.
     *
     * @return the current value of openValue
     */
    public double getOpenValue() {
        return openValue;
    }

    /**
     * Setter method for openValue.
     *
     * @param aOpenValue the new value for openValue
     */
    public void setOpenValue(double aOpenValue) {
        openValue = aOpenValue;
    }

    /**
     * Access method for volume.
     *
     * @return the current value of volume
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Setter method for volume.
     *
     * @param aVolume the new value for volume
     */
    public void setVolume(double aVolume) {
        volume = aVolume;
    }

    /**
     * Access method for position.
     *
     * @return the current value of position
     */
    public Set<Position> getPosition() {
        return position;
    }

    /**
     * Setter method for position.
     *
     * @param aPosition the new value for position
     */
    public void setPosition(Set<Position> aPosition) {
        position = aPosition;
    }

    /**
     * Access method for quoteIndicator.
     *
     * @return the current value of quoteIndicator
     */
    public Set<QuoteIndicator> getQuoteIndicator() {
        return quoteIndicator;
    }

    /**
     * Setter method for quoteIndicator.
     *
     * @param aQuoteIndicator the new value for quoteIndicator
     */
    public void setQuoteIndicator(Set<QuoteIndicator> aQuoteIndicator) {
        quoteIndicator = aQuoteIndicator;
    }

    /**
     * Access method for quoteShift.
     *
     * @return the current value of quoteShift
     */
    public Set<QuoteShift> getQuoteShift() {
        return quoteShift;
    }

    /**
     * Setter method for quoteShift.
     *
     * @param aQuoteShift the new value for quoteShift
     */
    public void setQuoteShift(Set<QuoteShift> aQuoteShift) {
        quoteShift = aQuoteShift;
    }

    /**
     * Access method for stock.
     *
     * @return the current value of stock
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * Setter method for stock.
     *
     * @param aStock the new value for stock
     */
    public void setStock(Stock aStock) {
        stock = aStock;
    }

    /**
     * Access method for timeframe.
     *
     * @return the current value of timeframe
     */
    public Timeframe getTimeframe() {
        return timeframe;
    }

    /**
     * Setter method for timeframe.
     *
     * @param aTimeframe the new value for timeframe
     */
    public void setTimeframe(Timeframe aTimeframe) {
        timeframe = aTimeframe;
    }

    /**
     * Compares the key for this instance with another Quote.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Quote and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Quote)) {
            return false;
        }
        Quote that = (Quote) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Quote.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Quote)) return false;
        return this.equalKeys(other) && ((Quote)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Quote |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Date getDateOfQuote() {
		return dateOfQuote;
	}

	public void setDateOfQuote(Date dateOfQuote) {
		this.dateOfQuote = dateOfQuote;
	}

}
