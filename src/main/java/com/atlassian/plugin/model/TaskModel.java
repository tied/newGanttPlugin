package com.atlassian.plugin.model;

import com.atlassian.jira.rest.client.api.domain.IssueField;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskModel {

    @XmlElement
    private Long id;
    @XmlElement
    private String status;
    @XmlElement
    private String title;
    @XmlElement
    private String start;
    @XmlElement
    private String end;
    @XmlElement
    private String author;
    @XmlElement
    private Long parentId;

    public TaskModel() {}
//    public TaskModel(IssueField issueField) {
//        issueField.getId();
//        issueField.getName();
//        issueField.getType();
//    }

//    public TaskModel(int id, String name, String type) {
//        this.id = id;
//        this.name = name;
//        this.type = type;
//    }

//    public TaskModel(Task task) {
//        setId(task.getId());
//        setName(task.getName());
//        setStatus(task.getStatus());
//        setBegin(task.getBegin());
//        setEnd(task.getEnd());
//        setAuthor(task.getAuthor());
//    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }


    public String getTitle() {
        return title;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getAuthor() {
        return author;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
