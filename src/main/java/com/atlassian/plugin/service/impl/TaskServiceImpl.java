package com.atlassian.plugin.service.impl;

import com.atlassian.jira.bc.issue.search.SearchService;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.search.SearchException;
import com.atlassian.jira.jql.builder.JqlQueryBuilder;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.jira.web.bean.PagerFilter;
import com.atlassian.plugin.model.TaskModel;
import com.atlassian.plugin.service.TaskService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class TaskServiceImpl implements TaskService {

    @ComponentImport
    private final IssueManager issueManager;

    @Inject
    public TaskServiceImpl(IssueManager issueManager) {
        this.issueManager = issueManager;
    }

    @Override
    public TaskModel getTaskById(int id) {
        return null;
    }

    @Override
    public List<TaskModel> getAllTasks() throws SearchException {

        List<TaskModel> taskModels = new ArrayList<>();

        ApplicationUser user = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();

        SearchService service = null;

        JqlQueryBuilder jqlQueryBuilder = JqlQueryBuilder.newBuilder();

        jqlQueryBuilder.where().project().eq("PLUGIN-GANTT").issueType().eq("Task");
//        service.search(user,
//                jqlQueryBuilder.buildQuery(),
//                PagerFilter.getUnlimitedFilter()).getResults();

        for (Issue issue : service.search(user,
                jqlQueryBuilder.buildQuery(),
                PagerFilter.getUnlimitedFilter()).getResults()) {
            TaskModel taskModel = new TaskModel();
            taskModel.setId(issue.getId());
            taskModel.setStatus(issue.getStatus().getDescription());
            taskModel.setName(issue.getSummary());
            taskModel.setBegin(issue.getCreated().toString());
            taskModel.setEnd(issue.getDueDate().toString());
            taskModel.setAuthor(issue.getReporter().getName());
            taskModel.setType(issue.getIssueType().getName());
            taskModels.add(taskModel);
        }

        System.out.println(taskModels);
        System.out.println(2);
        return taskModels;

    }
}