package com.atlassian.plugin.service.impl;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.component.pico.ComponentManager;
import com.atlassian.jira.issue.CustomFieldManager;
import com.atlassian.jira.issue.IssueManager;
import com.atlassian.jira.project.Project;
import com.atlassian.jira.project.ProjectManager;
import com.atlassian.jira.rest.client.api.domain.User;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.plugin.model.ProjectModel;
import com.atlassian.plugin.service.ProjectService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.user.UserManager;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {

    @ComponentImport
    private final ProjectManager projectManager;

    @ComponentImport
    private final UserManager userManager;

    @Inject
    public ProjectServiceImpl(ProjectManager projectManager, UserManager userManager) {
        this.projectManager = projectManager;
        this.userManager = userManager;
    }

    @Override
    public List<ProjectModel> getAllProjects() {

        //ApplicationUser applicationUser = ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();

//// Получаем компоненты-менеджеры
//        ComponentManager componentManager = ComponentManager.getInstance();
//        IssueManager issueManager = ComponentAccessor.getIssueManager();
//        CustomFieldManager customFieldManager = componentManager.getCustomFieldManager();
//
//// Текущий пользователь
//        User curUser = (User) ComponentAccessor.getJiraAuthenticationContext().getLoggedInUser();

        List<ProjectModel> projectModels = new ArrayList<>();

        //ProjectManager projectManager = ComponentAccessor.getProjectManager();

        for (Project project : projectManager.getProjects()) {
            ProjectModel projectModel = new ProjectModel();
            projectModel.setId(project.getId());
            projectModel.setName(project.getName());
            projectModels.add(projectModel);
        }
        System.out.println(projectModels);
        //System.getProperty("java.classpath");
        return projectModels;
    }
}
