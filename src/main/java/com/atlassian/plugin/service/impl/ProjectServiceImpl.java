package com.atlassian.plugin.service.impl;

import com.atlassian.jira.project.Project;
import com.atlassian.jira.project.ProjectImpl;
import com.atlassian.jira.project.ProjectManager;
import com.atlassian.plugin.model.ProjectModel;
import com.atlassian.plugin.service.ProjectService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.user.UserManager;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class ProjectServiceImpl implements ProjectService {

    @ComponentImport
    private final ProjectManager projectManager;

    @Inject
    public ProjectServiceImpl(ProjectManager projectManager) {
        this.projectManager = projectManager;
    }

    @Override
    public List<ProjectModel> getAllProjects() {

        List<ProjectModel> projectModels = new ArrayList<>();

        for (Project project : projectManager.getProjects()) {
            ProjectModel projectModel = new ProjectModel();
            projectModel.setId(project.getId());
            projectModel.setName(project.getName());
            projectModel.setDescription(project.getDescription());
            projectModels.add(projectModel);
        }
        return projectModels;
    }

    @Override
    public ProjectModel getProjectById(String id) {
        Project project = projectManager.getProjectByCurrentKeyIgnoreCase(id);
        ProjectModel projectModel = new ProjectModel();
        projectModel.setId(project.getId());
        projectModel.setName(project.getName());
        projectModel.setDescription(project.getDescription());
        return projectModel;
    }
}
