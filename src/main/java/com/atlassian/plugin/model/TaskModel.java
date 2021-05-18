package com.atlassian.plugin.model;

import com.atlassian.jira.rest.client.api.domain.IssueField;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskModel {

    @XmlElement
    private Long id;
    @XmlElement
    private String status;
    @XmlElement
    private String name;
    @XmlElement
    private String begin;
    @XmlElement
    private String end;
    @XmlElement
    private String author;
//    @XmlElement
//    private String type;

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

    public String getName() {
        return name;
    }

    public String getBegin() {
        return begin;
    }

    public String getEnd() {
        return end;
    }

    public String getAuthor() {
        return author;
    }

//    public String getType() { return type; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public void setType(String type) { this.type = type; }
}
