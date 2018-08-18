// Generated with g9.

package it.f12.stockprediction.entity.orm;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="timeframe")
public class Timeframe implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3152443772189388435L;

	/** Primary key. */
    protected static final String PK = "id";

    @Id
    @Column(unique=true, nullable=false, length=10)
    private int id;
    @Column(length=45)
    private String description;
    @OneToMany(mappedBy="timeframe")
    private Set<Quote> quote;

    /** Default constructor. */
    public Timeframe() {
        super();
    }

    public Timeframe(int i) {
        super();
        id = i;
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
     * Compares the key for this instance with another Timeframe.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Timeframe and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Timeframe)) {
            return false;
        }
        Timeframe that = (Timeframe) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Timeframe.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Timeframe)) return false;
        return this.equalKeys(other) && ((Timeframe)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Timeframe |");
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
