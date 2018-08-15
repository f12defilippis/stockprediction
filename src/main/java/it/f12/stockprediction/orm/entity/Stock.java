// Generated with g9.

package it.f12.stockprediction.orm.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="stock")
public class Stock implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @Column(unique=true, nullable=false, length=10)
    private int id;
    @Column(length=45)
    private String description;
    @OneToMany(mappedBy="stock")
    private Set<Quote> quote;
    @ManyToOne(optional=false)
    @JoinColumn(name="market", nullable=false)
    private Market market;

    /** Default constructor. */
    public Stock() {
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
     * Access method for description.
     *
     * @return the current value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for description.
     *
     * @param aDescription the new value for description
     */
    public void setDescription(String aDescription) {
        description = aDescription;
    }

    /**
     * Access method for quote.
     *
     * @return the current value of quote
     */
    public Set<Quote> getQuote() {
        return quote;
    }

    /**
     * Setter method for quote.
     *
     * @param aQuote the new value for quote
     */
    public void setQuote(Set<Quote> aQuote) {
        quote = aQuote;
    }

    /**
     * Access method for market.
     *
     * @return the current value of market
     */
    public Market getMarket() {
        return market;
    }

    /**
     * Setter method for market.
     *
     * @param aMarket the new value for market
     */
    public void setMarket(Market aMarket) {
        market = aMarket;
    }

    /**
     * Compares the key for this instance with another Stock.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Stock and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Stock)) {
            return false;
        }
        Stock that = (Stock) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Stock.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Stock)) return false;
        return this.equalKeys(other) && ((Stock)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Stock |");
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
