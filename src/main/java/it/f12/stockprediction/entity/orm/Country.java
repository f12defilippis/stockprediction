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

@Entity(name="country")
public class Country implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4074460380100377013L;

	/** Primary key. */
    protected static final String PK = "id";

    @Id
    @Column(unique=true, nullable=false, length=10)
    private int id;
    @Column(length=45)
    private String description;
    @OneToMany(mappedBy="country")
    private Set<Market> market;

    /** Default constructor. */
    public Country() {
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
     * Access method for market.
     *
     * @return the current value of market
     */
    public Set<Market> getMarket() {
        return market;
    }

    /**
     * Setter method for market.
     *
     * @param aMarket the new value for market
     */
    public void setMarket(Set<Market> aMarket) {
        market = aMarket;
    }

    /**
     * Compares the key for this instance with another Country.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Country and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Country)) {
            return false;
        }
        Country that = (Country) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Country.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Country)) return false;
        return this.equalKeys(other) && ((Country)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Country |");
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
