package com.atlassian.plugin.service;

import com.atlassian.jira.issue.search.SearchException;
import com.atlassian.plugin.model.TaskModel;
import com.atlassian.sal.api.search.SearchResults;

import java.util.List;

public interface TaskService {
    List<TaskModel> getAllTasks() throws SearchException;

    TaskModel getTaskById(int id);
}
