package com.atlassian.plugin;

import com.atlassian.plugin.service.impl.ProjectServiceImpl;
import com.atlassian.plugin.service.impl.TaskServiceImpl;

public class Main {
    public static void main(String[] args) {
        TaskServiceImpl taskServiceImpl = new TaskServiceImpl();
        taskServiceImpl.getAllTasks();

        ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl();
        projectServiceImpl.getAllProjects();
    }
}

