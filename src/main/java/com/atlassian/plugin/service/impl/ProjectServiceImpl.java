package com.atlassian.plugin.service.impl;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.project.Project;
import com.atlassian.jira.project.ProjectManager;
import com.atlassian.plugin.model.ProjectModel;
import com.atlassian.plugin.service.ProjectService;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    @Inject
    public ProjectServiceImpl() {}

    //final String PROJECT_NAME = "PLUGIN-GANTT";
    @Override
    public List<ProjectModel> getAllProjects() {

//        final String JIRA_URL = "https://localhost:2990/jira/";
//        final String JIRA_ADMIN_USERNAME = "admin";
//        final String JIRA_ADMIN_PASSWORD = "admin";

        List<ProjectModel> projectModels = new ArrayList<>();

        ProjectManager projectManager = ComponentAccessor.getProjectManager();

        for (Project project : projectManager.getProjects()) {
            ProjectModel projectModel = new ProjectModel();
            projectModel.setId(project.getId());
            projectModel.setName(project.getName());
            projectModels.add(projectModel);
        }
        System.out.println(projectModels);
        return projectModels;
    }
}
