package com.atlassian.plugin.service.impl;

import com.atlassian.jira.bc.issue.IssueService;
import com.atlassian.jira.bc.issue.search.SearchService;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.exception.CreateException;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.issue.issuetype.IssueType;
import com.atlassian.jira.issue.search.SearchException;
import com.atlassian.jira.issue.search.SearchResults;
import com.atlassian.jira.jql.builder.JqlQueryBuilder;
import com.atlassian.jira.project.Project;
import com.atlassian.jira.project.ProjectManager;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.jira.web.bean.PagerFilter;
import com.atlassian.plugin.model.TaskModel;
import com.atlassian.plugin.service.TaskService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.query.Query;
import com.atlassian.query.order.SortOrder;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class TaskServiceImpl implements TaskService {

    @ComponentImport
    final IssueManager issueManager;

    @ComponentImport
    final ProjectManager projectManager;

    @Inject
    public TaskServiceImpl(IssueManager issueManager, ProjectManager projectManager) {
        this.issueManager = issueManager;
        this.projectManager = projectManager;
    }

    @Override
    public TaskModel getTaskById(int id) {
        return null;
    }

//    @Override
//    public Issue addIssue(String name, String begin, String end) throws CreateException {
//
//        TaskModel taskModel = new TaskModel();
//        taskModel.setName(name);
//        taskModel.setBegin(begin);
//        taskModel.setEnd(end);
//        Issue issue = null;
//        ApplicationUser user = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();
//        Project project = ComponentAccessor.getProjectManager().getProjectObj(10100L);
//        IssueInputB
//    }

    @Override
    public List<TaskModel> getAllTasks() throws SearchException {

        List<TaskModel> taskModels = new ArrayList<>();
        ApplicationUser user = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();
        Project project = ComponentAccessor.getProjectManager().getProjectObj(10000L);
//        Query query = JqlQueryBuilder.newBuilder()
//                .where()
//                .project().eq().string(project.getKey())
//                .and()
//                .issueType().eq().string("10000")
//                .endWhere()
//                .orderBy().add("Rank", SortOrder.ASC)
//                .buildQuery();
        Query query = JqlQueryBuilder.newBuilder()
                .where()
                .project().eq().string(project.getKey())
                .and()
                .issueType().isNotEmpty()
                .endWhere()
                .orderBy().add("Rank", SortOrder.ASC)
                .buildQuery();

        List<Issue> issues = ComponentAccessor.getComponentOfType(SearchService.class).search(user, query, PagerFilter.getUnlimitedFilter()).getResults();

        for (Issue issue : issues) {
            TaskModel taskModel = new TaskModel();
            taskModel.setId(issue.getId());
            taskModel.setStatus(issue.getStatus().getStatusCategory().getName());
            taskModel.setTitle(issue.getSummary());
            taskModel.setStart(issue.getCreated().toString());
            if (issue.getDueDate() != null) { taskModel.setEnd(issue.getDueDate().toString()); }
            taskModel.setParentId(issue.getParentId());
            taskModel.setAuthor(issue.getReporter().getName());
//            taskModel.setProgress(issue.getProgress());
            taskModels.add(taskModel);
        }
        return taskModels;
   }


}