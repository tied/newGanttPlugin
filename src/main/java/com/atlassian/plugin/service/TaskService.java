package com.atlassian.plugin.service;

import com.atlassian.jira.exception.CreateException;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.search.SearchException;
import com.atlassian.jira.issue.search.SearchResults;
import com.atlassian.plugin.model.TaskModel;

import java.util.List;

public interface TaskService {
    //SearchResults<Issue> getAllTasks() throws SearchException;

    List<TaskModel> getAllTasks() throws SearchException;

    TaskModel getTaskById(int id);

//    Issue addIssue() throws CreateException;
}
