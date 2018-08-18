// Generated with g9.

package it.f12.stockprediction.entity.orm;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="position_history")
public class PositionHistory implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1892179204626248145L;

	/** Primary key. */
    protected static final String PK = "PositionHistoryPrimary";
    @Id
    @Column(unique=true, nullable=false, length=10)
    private int id;
    @Column(name="start_date", nullable=false)
    private Timestamp startDate;
    @ManyToOne(optional=false)
    @JoinColumn(name="position", nullable=false)
    private Position position;
    @ManyToOne(optional=false)
    @JoinColumn(name="position_status", nullable=false)
    private PositionStatus positionStatus;

    /** Default constructor. */
    public PositionHistory() {
        super();
    }

    /**
     * Access method for startDate.
     *
     * @return the current value of startDate
     */
    public Timestamp getStartDate() {
        return startDate;
    }

    /**
     * Setter method for startDate.
     *
     * @param aStartDate the new value for startDate
     */
    public void setStartDate(Timestamp aStartDate) {
        startDate = aStartDate;
    }

    /**
     * Access method for position.
     *
     * @return the current value of position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Setter method for position.
     *
     * @param aPosition the new value for position
     */
    public void setPosition(Position aPosition) {
        position = aPosition;
    }

    /**
     * Access method for positionStatus.
     *
     * @return the current value of positionStatus
     */
    public PositionStatus getPositionStatus() {
        return positionStatus;
    }

    /**
     * Setter method for positionStatus.
     *
     * @param aPositionStatus the new value for positionStatus
     */
    public void setPositionStatus(PositionStatus aPositionStatus) {
        positionStatus = aPositionStatus;
    }

    /** Temporary value holder for group key fragment positionId */
    private transient int tempPositionId;

    /**
     * Gets the key fragment id for member position.
     * If this.position is null, a temporary stored value for the key
     * fragment will be returned. The temporary value is set by setPositionId.
     * This behavior is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @return Current (or temporary) value of the key fragment
     * @see Position
     */
    public int getPositionId() {
        return (getPosition() == null ? tempPositionId : getPosition().getId());
    }

    /**
     * Sets the key fragment id from member position.
     * If this.position is null, the passed value will be temporary
     * stored, and returned by subsequent calls to getPositionId.
     * This behaviour is required by some persistence libraries to allow
     * fetching of objects in arbitrary order.
     *
     * @param aId New value for the key fragment
     * @see Position
     */
    public void setPositionId(int aId) {
        if (getPosition() == null) {
            tempPositionId = aId;
        } else {
            getPosition().setId(aId);
        }
    }

    /**
     * Compares the key for this instance with another PositionHistory.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PositionHistory and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PositionHistory)) {
            return false;
        }
        PositionHistory that = (PositionHistory) other;
        Object myStartDate = this.getStartDate();
        Object yourStartDate = that.getStartDate();
        if (myStartDate==null ? yourStartDate!=null : !myStartDate.equals(yourStartDate)) {
            return false;
        }
        if (this.getPositionId() != that.getPositionId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PositionHistory.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PositionHistory)) return false;
        return this.equalKeys(other) && ((PositionHistory)other).equalKeys(this);
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
        if (getStartDate() == null) {
            i = 0;
        } else {
            i = getStartDate().hashCode();
        }
        result = 37*result + i;
        i = getPositionId();
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
        StringBuffer sb = new StringBuffer("[PositionHistory |");
        sb.append(" startDate=").append(getStartDate());
        sb.append(" positionId=").append(getPositionId());
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
        ret.put("startDate", getStartDate());
        ret.put("positionId", Integer.valueOf(getPositionId()));
        return ret;
    }

}
