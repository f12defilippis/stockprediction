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

@Entity(name="strategy_parameter")
public class StrategyParameter implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5155543364100210257L;

	/** Primary key. */
    protected static final String PK = "id";

    @Id
    @Column(unique=true, nullable=false, length=10)
    private int id;
    @Column(nullable=false, precision=22)
    private double value;
    @OneToMany(mappedBy="strategyParameter")
    private Set<Position> position;
    @ManyToOne(optional=false)
    @JoinColumn(name="parameter_id", nullable=false)
    private Parameter parameter;
    @ManyToOne(optional=false)
    @JoinColumn(name="strategy_id", nullable=false)
    private Strategy strategy;

    /** Default constructor. */
    public StrategyParameter() {
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
     * Access method for value.
     *
     * @return the current value of value
     */
    public double getValue() {
        return value;
    }

    /**
     * Setter method for value.
     *
     * @param aValue the new value for value
     */
    public void setValue(double aValue) {
        value = aValue;
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
     * Access method for parameter.
     *
     * @return the current value of parameter
     */
    public Parameter getParameter() {
        return parameter;
    }

    /**
     * Setter method for parameter.
     *
     * @param aParameter the new value for parameter
     */
    public void setParameter(Parameter aParameter) {
        parameter = aParameter;
    }

    /**
     * Access method for strategy.
     *
     * @return the current value of strategy
     */
    public Strategy getStrategy() {
        return strategy;
    }

    /**
     * Setter method for strategy.
     *
     * @param aStrategy the new value for strategy
     */
    public void setStrategy(Strategy aStrategy) {
        strategy = aStrategy;
    }

    /**
     * Compares the key for this instance with another StrategyParameter.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class StrategyParameter and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof StrategyParameter)) {
            return false;
        }
        StrategyParameter that = (StrategyParameter) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another StrategyParameter.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof StrategyParameter)) return false;
        return this.equalKeys(other) && ((StrategyParameter)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[StrategyParameter |");
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
