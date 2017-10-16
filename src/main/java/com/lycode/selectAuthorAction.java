package com.lycode;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

// Select Author
public class selectAuthorAction extends ActionSupport {
    private String authorID;
    @Override
    public String execute() throws Exception {
        if(authorID != null && !authorID.equals("")){
            ActionContext.getContext().getSession().put("authorID",authorID);
        }
        return SUCCESS;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }
}
