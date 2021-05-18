package com.atlassian.plugin.rest;

import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.search.SearchException;
import com.atlassian.jira.issue.search.SearchResults;
import com.atlassian.plugin.model.TaskModel;
import com.atlassian.plugin.service.TaskService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/task")
public class TaskRest {

    private final TaskService taskService;

    @Inject
    public TaskRest(TaskService taskService) {
        this.taskService = taskService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllTasks")
    public List<TaskModel> getAllTasks() throws SearchException {
        return taskService.getAllTasks();
//        List<TaskModel> taskModels = new ArrayList<>();
//        return taskModels;
    }
}
