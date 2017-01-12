package com.voyagerproject.connector.jira;

import com.voyagerproject.connector.IConnector;
import com.voyagerproject.connector.exception.ConnectorException;
import com.voyagerproject.connector.model.VoyagerIssue;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraConnector implements IConnector<Issue> {
	static BasicCredentials creds;
    static JiraClient jiraClient;
    
    /**
     * Connects to the specified url with the defined email and password
     * 
     * @param url
     * @param email
     * @param password
     */
	static public JiraClient connect(String url, String email, String password) {
    	// In case the parameters are always the same, jiraClient can be used as a singleton
    	// If the connection has already been established return the old connection
    	if (jiraClient != null) {
    		return jiraClient;
    	}
    	// Connect to the Jira Client
    	creds = new BasicCredentials(email, password);
		jiraClient = new JiraClient(url, creds);
    	
    	return jiraClient;
    }

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.voyagerproject.connector.IConnector#createIssue(com.voyagerproject.
	 * connector.model.VoyagerIssue)
	 */
	@Override
	public Issue createIssue(VoyagerIssue issue) throws ConnectorException {
		Issue newIssue;
		try {
			newIssue = jiraClient.createIssue(issue.getProject(), issue.getIssueType())
					.field(Field.SUMMARY, issue.getSummary()).field(Field.DESCRIPTION, issue.getDescription())
					.field(Field.REPORTER, issue.getReporter()).field(Field.ASSIGNEE, issue.getAssignee()).execute();
		} catch (JiraException jException) {
			throw new ConnectorException(jException.getMessage());
		}

		return newIssue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.voyagerproject.connector.IConnector#addcomment(net.rcarz.jiraclient.
	 * Issue, java.lang.String)
	 */
	@Override
	public Issue addcomment(Issue issue, String comment) throws ConnectorException {
		try {
			issue.addComment(comment);
		} catch (JiraException jException) {
			throw new ConnectorException(jException.getMessage());
		}

		return issue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.voyagerproject.connector.IConnector#transitionIssue(net.rcarz.
	 * jiraclient.Issue, java.lang.String)
	 */
	@Override
	public Issue transitionIssue(Issue issue, String status) throws ConnectorException {
		try {
			issue.transition().execute(status);
		} catch (JiraException jException) {
			throw new ConnectorException(jException.getMessage());
		}

		return issue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.voyagerproject.connector.IConnector#reassignIssue(net.rcarz.
	 * jiraclient.Issue, java.lang.String)
	 */
	@Override
	public Issue reassignIssue(Issue issue, String assignee) throws ConnectorException {
		try {
			issue.update().field(Field.ASSIGNEE, assignee).execute();
		} catch (JiraException jException) {
			throw new ConnectorException(jException.getMessage());
		}

		return issue;
	}

}
