//////package com.atlassian.plugin.service.impl;
//////
//////import com.atlassian.jira.rest.client.api.JiraRestClient;
//////import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
//////import com.atlassian.jira.rest.client.api.domain.BasicProject;
//////import com.atlassian.jira.rest.client.api.domain.Issue;
//////import com.atlassian.jira.rest.client.api.domain.SearchResult;
//////import com.atlassian.jira.rest.client.api.domain.User;
//////import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
//////import com.atlassian.plugin.model.TaskModel;
//////import com.atlassian.plugin.service.TaskService;
//////import com.atlassian.util.concurrent.Promise;
//////import java.net.URI;
//////import java.net.URISyntaxException;
//////
//////public class TaskServiceImpl implements TaskService {
//////
//////    private static final String JIRA_URL = "http://jira-dev:2990";
//////    private static final String JIRA_ADMIN_USERNAME = "admin";
//////    private static final String JIRA_ADMIN_PASSWORD = "admin";
//////
//////    public TaskServiceImpl() throws URISyntaxException {
//////    }
//////
//////    @Override
//////    public TaskModel[] getAllTasks() {
//////        return new TaskModel[0];
//////    }
//////
//////    @Override
//////    public TaskModel getTaskById(int id) {
//////        return null;
//////    }
//////
////////    JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
////////    URI uri = new URI(JIRA_URL);
////////    JiraRestClient client = factory.createWithBasicHttpAuthentication(uri, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD);
////////
////////    Promise<User> promise = client.getUserClient().getUser("admin");
////////    User user = promise.claim();
////////
////////
////////    for (BasicProject project : client.getProjectClient().getAllProjects().claim()) {
////////        System.out.println(project.getKey() + ": " + project.getName());
////////    }
////////
////////    Promise<SearchResult> searchJqlPromise = client.getSearchClient().searchJql("project = PLUGIN-GANTT AND status in (Closed, Completed, Resolved) ORDER BY assignee, resolutiondate");
//////
////////    for (Issue issue : searchJqlPromise.claim().getIssues()) {
////////        System.out.println(issue.getSummary());
////////    }
////////    public static void main(String[] args) throws Exception {
////////        // Construct the JRJC client
////////        System.out.println(String.format("Logging in to %s with username '%s' and password '%s'", JIRA_URL, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD));
////////        JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
////////        URI uri = new URI(JIRA_URL);
////////        JiraRestClient client = factory.createWithBasicHttpAuthentication(uri, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD);
////////
////////        // Invoke the JRJC Client
////////        Promise<User> promise = client.getUserClient().getUser("admin");
////////        User user = promise.claim();
////////
////////        for (BasicProject project : client.getProjectClient().getAllProjects().claim()) {
////////            System.out.println(project.getKey() + ": " + project.getName());
////////        }
////////
////////        Promise<SearchResult> searchJqlPromise = client.getSearchClient().searchJql("project = MYPURRJECT AND status in (Closed, Completed, Resolved) ORDER BY assignee, resolutiondate");
////////
////////        for (Issue issue : searchJqlPromise.claim().getIssues()) {
////////            System.out.println(issue.getSummary());
////////        }
////////
////////        // Print the result
////////        System.out.println(String.format("Your admin user's email address is: %s\r\n", user.getEmailAddress()));
////////
////////        // Done
////////        System.out.println("Example complete. Now exiting.");
////////        System.exit(0);
////////    }
//////}
//package com.atlassian.plugin.service.impl;
//
//import com.atlassian.activeobjects.external.ActiveObjects;
//import com.atlassian.jira.rest.client.api.IssueRestClient;
//import com.atlassian.jira.rest.client.api.JiraRestClient;
//import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
//import com.atlassian.jira.rest.client.api.ProjectRestClient;
//import com.atlassian.jira.rest.client.api.domain.*;
//import com.atlassian.jira.rest.client.auth.BasicHttpAuthenticationHandler;
//import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
//import com.atlassian.plugin.model.TaskModel;
//import com.atlassian.plugin.service.TaskService;
//import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
//import com.atlassian.util.concurrent.Promise;
//
//import java.net.URI;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//public class TaskServiceImpl implements TaskService {

//
//        final String JIRA_URL = "https://localhost:2990/jira/";
//        final String JIRA_ADMIN_USERNAME = "admin";
//        final String JIRA_ADMIN_PASSWORD = "admin";
//
//        final TaskModel taskModel = new TaskModel();
//
//        //System.out.println(String.format("Logging in to %s with username '%s' and password '%s'", JIRA_URL, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD));
//        AsynchronousJiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
//        URI uri = URI.create(JIRA_URL);
//        JiraRestClient client = factory.createWithBasicHttpAuthentication(uri, JIRA_ADMIN_USERNAME, JIRA_ADMIN_PASSWORD);
//
//        // Invoke the JRJC Client
//        Promise<User> promise = client.getUserClient().getUser("admin");
//        User user = promise.claim();
//
//        for (BasicProject project : client.getProjectClient().getAllProjects().claim()) {
//            //System.out.println(project.getKey() + ": " + project.getName());
//        }
//
//        Promise<SearchResult> searchJqlPromise = client.getSearchClient().searchJql("project = PLUGIN-GANTT AND status in (Closed, Completed, Resolved) ORDER BY assignee, resolutiondate");
//
//        for (Issue issue : searchJqlPromise.claim().getIssues()) {
//            //System.out.println(issue.getSummary());
//            taskModel.setId(issue.getId());
//            taskModel.setStatus(issue.getStatus().getDescription());
//            taskModel.setName(issue.getSummary());
//            taskModel.setBegin(issue.getCreationDate().toString());
//            taskModel.setEnd(issue.getDueDate().toString());
//            taskModel.setAuthor(issue.getReporter().getName());
//            taskModel.setType(issue.getIssueType().getName());
//        }
//        taskModels.add(taskModel);
//        return taskModels;
//    }
////    public static void main(String[] args) {
////
////        TaskServiceImpl taskServiceImpl = new TaskServiceImpl();
////        taskServiceImpl.serviceRestAPI();
////    }
//}