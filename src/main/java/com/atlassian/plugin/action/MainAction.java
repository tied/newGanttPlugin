package com.atlassian.plugin.action;

import com.atlassian.jira.web.action.JiraWebActionSupport;

public class MainAction extends JiraWebActionSupport{

    @Override
    public String doDefault() throws Exception {
        return super.doDefault();
    }

    @Override
    protected String doExecute() throws Exception {
        return super.doExecute();
    }

//    public final AccessService accessService;
//
//    public MainAction(AccessService accessService) {
//        this.accessService = accessService;
//    }
//
//    public boolean hasAccess() {
//        return accessService.hasAccess();
//    }
//
//    public boolean isUser() {
//        return accessService.isUser();
//    }
//
//    public boolean isLibraryAdmin() {
//        return accessService.isLibraryAdmin();
//    }
//
//    public boolean isAdmin() {
//        return accessService.isAdmin();
//    }
//}


}