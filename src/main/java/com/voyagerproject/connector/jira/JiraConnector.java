package com.voyagerproject.connector.jira;

import java.net.URL;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.JiraClient;

public class JiraConnector {
	static BasicCredentials creds;
    static JiraClient jiraClient;
    
    /**
     * Connects to the specified url with the defined email and password
     * 
     * @param url
     * @param email
     * @param password
     */
    static public JiraClient connect(URL url , String email, String password){
    	// In case the parameters are always the same, jiraClient can be used as a singleton
    	// If the connection has already been established return the old connection
    	if (jiraClient != null) {
    		return jiraClient;
    	}
    	// Connect to the Jira Client
    	creds = new BasicCredentials(email, password);
    	jiraClient = new JiraClient(url.toString(), creds);
    	
    	return jiraClient;
    }

}
