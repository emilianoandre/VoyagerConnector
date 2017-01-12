/**
 * 
 */
package com.voyagerproject.connector;

import com.voyagerproject.connector.exception.ConnectorException;
import com.voyagerproject.connector.model.VoyagerIssue;

/**
 * Main Interface for the Issue Tracker Connector classes
 * 
 * @author eandre
 *
 */
public interface IConnector<T> {

	/**
	 * Creates an issue on the selected issue tracker
	 * 
	 * @param issue
	 *            the details of the new issue to be created
	 * @return the created issue
	 */
	public T createIssue(VoyagerIssue issue) throws ConnectorException;

	/**
	 * Adds a comment to the selected issue
	 * 
	 * @param issue
	 *            the issue to add the comment to
	 * @param comment
	 *            the comment to be added
	 * @return the updated issue
	 */
	public T addcomment(T issue, String comment) throws ConnectorException;

	/**
	 * Changes the status of an issue
	 * 
	 * @param issue
	 *            the issue to update
	 * @param status
	 *            the status to be updated to
	 * @return the updated issue
	 */
	public T transitionIssue(T issue, String status) throws ConnectorException;

	/**
	 * Changes the assignee of an issue
	 * 
	 * @param issue
	 *            the issue to update
	 * @param assignee
	 *            the person to assign the issue to
	 * @return the updated issue
	 */
	public T reassignIssue(T issue, String assignee) throws ConnectorException;

}
