package com.atlassian.plugin.service.impl;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.jql.builder.JqlQueryBuilder;
import com.atlassian.jira.project.ProjectManager;
import com.atlassian.plugin.model.TaskModel;
import com.atlassian.plugin.service.TaskService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Named
public class TaskServiceImpl implements TaskService {
    @Inject
    public TaskServiceImpl() {}

    @Override
    public TaskModel getTaskById(int id) {
        return null;
    }

    @Override
    public List<TaskModel> getAllTasks() {
        List<TaskModel> taskModels = new ArrayList<>();

//        IssueManager issueManager = ComponentAccessor.getIssueManager();
//        JqlQueryBuilder jqlQueryBuilder = JqlQueryBuilder.newBuilder();
//
//        jqlQueryBuilder.where().project().eq("PLUGIN-GANTT").issueType().eq("Task");

//        for (Issue issue : ) {
//            TaskModel taskModel = new TaskModel();
//            taskModel.setId(issue.getId());
//            taskModel.setStatus(issue.getStatus().getDescription());
//            taskModel.setName(issue.getSummary());
//            taskModel.setBegin(issue.getCreated().toString());
//            taskModel.setEnd(issue.getDueDate().toString());
//            taskModel.setAuthor(issue.getReporter().getName());
//            taskModel.setType(issue.getIssueType().getName());
//            taskModels.add(taskModel);
//        }

        return taskModels;

    }
}