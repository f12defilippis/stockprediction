// Generated with g9.

package it.f12.stockprediction.entity.orm;

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

@Entity(name="position")
public class Position implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8836791525370800752L;

	/** Primary key. */
    protected static final String PK = "id";

    @Id
    @Column(unique=true, nullable=false, length=10)
    private int id;
    @ManyToOne(optional=false)
    @JoinColumn(name="action", nullable=false)
    private Action action;
    @OneToMany(mappedBy="position")
    private Set<PositionHistory> positionHistory;
    @ManyToOne(optional=false)
    @JoinColumn(name="quote", nullable=false)
    private Quote quote;
    @ManyToOne(optional=false)
    @JoinColumn(name="strategy_parameter", nullable=false)
    private StrategyParameter strategyParameter;

    /** Default constructor. */
    public Position() {
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
     * Access method for action.
     *
     * @return the current value of action
     */
    public Action getAction() {
        return action;
    }

    /**
     * Setter method for action.
     *
     * @param aAction the new value for action
     */
    public void setAction(Action aAction) {
        action = aAction;
    }

    /**
     * Access method for positionHistory.
     *
     * @return the current value of positionHistory
     */
    public Set<PositionHistory> getPositionHistory() {
        return positionHistory;
    }

    /**
     * Setter method for positionHistory.
     *
     * @param aPositionHistory the new value for positionHistory
     */
    public void setPositionHistory(Set<PositionHistory> aPositionHistory) {
        positionHistory = aPositionHistory;
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
     * Access method for strategyParameter.
     *
     * @return the current value of strategyParameter
     */
    public StrategyParameter getStrategyParameter() {
        return strategyParameter;
    }

    /**
     * Setter method for strategyParameter.
     *
     * @param aStrategyParameter the new value for strategyParameter
     */
    public void setStrategyParameter(StrategyParameter aStrategyParameter) {
        strategyParameter = aStrategyParameter;
    }

    /**
     * Compares the key for this instance with another Position.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Position and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Position)) {
            return false;
        }
        Position that = (Position) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Position.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Position)) return false;
        return this.equalKeys(other) && ((Position)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Position |");
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
