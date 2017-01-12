package com.voyagerproject.connector.model;

/**
 * Main class for the Voyager Issues
 * 
 * @author eandre
 * 
 */
public class VoyagerIssue {

	private String project;
	private String issueType;
	private String summary;
	private String description;
	private String reporter;
	private String assignee;

	/**
	 * @param project
	 *            the project key in the issue tracker
	 * @param issueType
	 *            the issue type
	 * @param summary
	 *            the issue summary to be displayed in the tracker
	 * @param description
	 *            the issue description
	 * @param reporter
	 *            who created the issue
	 * @param assignee
	 *            who will be working on the issue
	 */
	public VoyagerIssue(String project, String issueType, String summary, String description, String reporter,
			String assignee) {
		this.project = project;
		this.issueType = issueType;
		this.summary = summary;
		this.description = description;
		this.reporter = reporter;
		this.assignee = assignee;
	}

	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}

	/**
	 * @return the issueType
	 */
	public String getIssueType() {
		return issueType;
	}

	/**
	 * @param issueType
	 *            the issueType to set
	 */
	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary
	 *            the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the reporter
	 */
	public String getReporter() {
		return reporter;
	}

	/**
	 * @param reporter
	 *            the reporter to set
	 */
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	/**
	 * @return the assignee
	 */
	public String getAssignee() {
		return assignee;
	}

	/**
	 * @param assignee
	 *            the assignee to set
	 */
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}

}
