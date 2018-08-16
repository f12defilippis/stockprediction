// Generated with g9.

package it.f12.stockprediction.entity.orm;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="quote")
public class Quote implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @Column(unique=true, nullable=false, length=10)
    private int id;
    @Column(name="date_of_quote")
    private Timestamp dateOfQuote;
    @Column(precision=3)
    private Double value;

    @Column(precision=3,name="min_value")
    private Double minValue;
    @Column(precision=3,name="max_value")
    private Double maxValue;
    @Column(precision=3,name="open_value")
    private Double openValue;
    
    
    @OneToMany(mappedBy="quote")
    private Set<QuoteIndicator> quoteIndicator;
    @OneToMany(mappedBy="quote")
    private Set<QuoteShift> quoteShift;
    @ManyToOne(optional=false)
    @JoinColumn(name="stock", nullable=false)
    private Stock stock;

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
     * Access method for dateOfQuote.
     *
     * @return the current value of dateOfQuote
     */
    public Timestamp getDateOfQuote() {
        return dateOfQuote;
    }

    /**
     * Setter method for dateOfQuote.
     *
     * @param aDateOfQuote the new value for dateOfQuote
     */
    public void setDateOfQuote(Timestamp aDateOfQuote) {
        dateOfQuote = aDateOfQuote;
    }

    /**
     * Access method for value.
     *
     * @return the current value of value
     */
    public Double getValue() {
        return value;
    }

    /**
     * Setter method for value.
     *
     * @param aValue the new value for value
     */
    public void setValue(Double aValue) {
        value = aValue;
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

	public Double getMinValue() {
		return minValue;
	}

	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}

	public Double getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}

	public Double getOpenValue() {
		return openValue;
	}

	public void setOpenValue(Double openValue) {
		this.openValue = openValue;
	}

}
