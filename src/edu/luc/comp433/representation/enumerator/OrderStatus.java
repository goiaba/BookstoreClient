package edu.luc.comp433.representation.enumerator;

/**
 * Possible OrderRepresentation Statuses are: Processing, Shipped, Delivered and Canceled.
 *
 * @author Thiago Vieira Puluceno
 *
 */
public enum OrderStatus {

	/**
	 * Processing
	 */
	PROCESSING,
	/**
	 * Shipped
	 */
	SHIPPED,
	/**
	 * Delivered
	 */
	DELIVERED,
	/**
	 * Canceled
	 */
	CANCELED;

	/**
	 * @return
	 */
	public String value() {
		return name();
	}
}

