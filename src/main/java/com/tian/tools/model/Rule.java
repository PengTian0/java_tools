package com.tian.tools.model;
import org.springframework.data.annotation.Id;

public class Rule {
    @Id
    private String id;
    private String group;
    private String name;
    private Integer salience;
    private String condition;
    private String action;
    private String comments;

    public String getGroup(){
        return this.group;
    }

    public void setGroup(String group){
        this.group = group;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getSalience(){
        return this.salience;
    }

    public void setSalience(Integer salience){
        this.salience = salience;
    }

    public String getCondition(){
        return this.condition;
    }

    public void setCondition(String condition){
        this.condition = condition;
    }

    public String getAction(){
        return this.action;
    }

    public void setAction(String action){
        this.action = action;
    }

    public String getComments(){
        return this.comments;
    }

    public void setComments(String comments){
        this.comments = comments;
    }
}
