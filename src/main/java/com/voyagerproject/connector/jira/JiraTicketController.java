package com.voyagerproject.connector.jira;

import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;

public class JiraTicketController {
	
	JiraClient jiraClient;
	
	/**
	 * Constructor with the JiraClient as parameter
	 * 
	 * @param connector
	 */
	public JiraTicketController(JiraClient jiraClient) {
		this.jiraClient = jiraClient;
	}
	
	/**
	 * Gets the list of tickets that matches the query and runs the checks against it
	 * 
	 * @param jqlQuery
	 */
	public void checkQueryTickets(String jqlQuery) {
        Issue.SearchResult tickets;
		try {
			tickets = jiraClient.searchIssues(jqlQuery);
	        System.out.println("Total: " + tickets.total);
	        for (Issue ticket : tickets.issues) {
	            System.out.println("- " + ticket.getKey() + " // " + ticket.getSummary());
	            System.out.println("- " + ticket.getKey() + " // " + ticket.getStatus());
	            System.out.println("- " + ticket.getKey() + " // " + ticket.getAssignee());	
	            applyTicketChecks(ticket);
	        }
		} catch (JiraException jEx) {
			jEx.printStackTrace();
		}
	}
	
	/**
	 * Applys different checks to a ticket looking for issues with the filling of the ticket
	 * Then sends an email to the owner of the ticket to fix those issues
	 *  
	 * @param ticket
	 */
	public void applyTicketChecks(Issue ticket){
		// Check if the ticket is assigned to me
		if (!ticket.getAssignee().getName().equals("eandre")) {
			if (ticket.getStatus().getName().equalsIgnoreCase("Open") || ticket.getStatus().getName().equalsIgnoreCase("Pending DEV ")) {
				System.out.println("Failed - " + ticket.getKey() + " // " + ticket.getSummary());
			}
		} else if (ticket.getStatus().getName().equalsIgnoreCase("In Dev")){
			System.out.println("Failed - " + ticket.getKey() + " // " + ticket.getSummary());
		}
		
		// Check if the ticket is Assigned
		
		
	}

}
