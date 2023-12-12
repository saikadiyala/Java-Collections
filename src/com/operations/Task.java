package com.operations;

enum Status{
    IN_QUEUE, ASSIGNED, IN_PROGRESS;
}
enum Priority{
    HIGH,LOW,MEDIUM;
}

public class Task implements Comparable<Task>{

    private String project_name;
    private String description;
    private String assignee;
    private Priority priority;
    private Status status;


    public Task(String project_name, String description, String assignee, Priority priority, Status status) {
        this.project_name = project_name;
        this.description = description;
        this.assignee = assignee;
        this.priority = priority;
        this.status = status;
    }

    public Task(String project_name, String description, String assignee, Priority priority) {
        this(project_name, description, assignee, priority, assignee==null?Status.IN_QUEUE:Status.ASSIGNED);
    }

    public Task(String project_name, String description, Priority priority) {
        this(project_name, description, null, priority);
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (!getProject_name().equals(task.getProject_name())) return false;
        return getDescription().equals(task.getDescription());
    }

    @Override
    public int hashCode() {
        int result = getProject_name().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }

    @Override
    public int compareTo(Task o) {
        int result=this.project_name.compareTo(o.project_name);
        if(result==0){
            result=this.description.compareTo(o.description);
        }
        return result;
    }

    @Override
    public String toString() {
        return
                "project_name='" + project_name + '\'' +
                ", description='" + description + '\'' +
                ", assignee='" + assignee + '\'' +
                ", priority=" + priority +
                ", status=" + status
                ;
    }
}
