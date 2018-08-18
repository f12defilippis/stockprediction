// Generated with g9.

package it.f12.stockprediction.entity.orm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

//@Entity(name="hibernate_sequence")
public class HibernateSequence implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4153830738831729062L;
	@Column(name="next_val", length=19)
    private long nextVal;

    /** Default constructor. */
    public HibernateSequence() {
        super();
    }

    /**
     * Access method for nextVal.
     *
     * @return the current value of nextVal
     */
    public long getNextVal() {
        return nextVal;
    }

    /**
     * Setter method for nextVal.
     *
     * @param aNextVal the new value for nextVal
     */
    public void setNextVal(long aNextVal) {
        nextVal = aNextVal;
    }

}
