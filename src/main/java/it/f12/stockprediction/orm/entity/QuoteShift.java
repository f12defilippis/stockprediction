// Generated with g9.

package it.f12.stockprediction.orm.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="quote_shift")
public class QuoteShift implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @Column(unique=true, nullable=false, length=10)
    private int id;
    @Column(name="num_days", length=10)
    private int numDays;
    @Column(precision=3)
    private BigDecimal value;
    @ManyToOne(optional=false)
    @JoinColumn(name="quote", nullable=false)
    private Quote quote;

    /** Default constructor. */
    public QuoteShift() {
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
     * Access method for numDays.
     *
     * @return the current value of numDays
     */
    public int getNumDays() {
        return numDays;
    }

    /**
     * Setter method for numDays.
     *
     * @param aNumDays the new value for numDays
     */
    public void setNumDays(int aNumDays) {
        numDays = aNumDays;
    }

    /**
     * Access method for value.
     *
     * @return the current value of value
     */
    public BigDecimal getValue() {
        return value;
    }

    /**
     * Setter method for value.
     *
     * @param aValue the new value for value
     */
    public void setValue(BigDecimal aValue) {
        value = aValue;
    }

    /**
     * Access method for quote.
     *
     * @return the current value of quote
     */
    public Quote getQuote() {
        return quote;
    }

    /**
     * Setter method for quote.
     *
     * @param aQuote the new value for quote
     */
    public void setQuote(Quote aQuote) {
        quote = aQuote;
    }

    /**
     * Compares the key for this instance with another QuoteShift.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class QuoteShift and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof QuoteShift)) {
            return false;
        }
        QuoteShift that = (QuoteShift) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another QuoteShift.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof QuoteShift)) return false;
        return this.equalKeys(other) && ((QuoteShift)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[QuoteShift |");
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

}
