package com.atlassian.plugin.rest;

import com.atlassian.jira.issue.search.SearchException;
import com.atlassian.jira.project.Project;
import com.atlassian.plugin.model.ProjectModel;
import com.atlassian.plugin.model.TaskModel;
import com.atlassian.plugin.service.ProjectService;
import com.atlassian.plugin.service.TaskService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/project")
public class ProjectRest {

    private final ProjectService projectService;

    @Inject
    public ProjectRest(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllProjects")
    public List<ProjectModel>  getAllProjects() throws SearchException {
        return projectService.getAllProjects();
    }
}
