package com.tian.tools.controller;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tian.tools.model.Rule;
import com.tian.tools.model.RuleRepository;

public class RuleController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final RuleRepository repository;

    public RuleController(RuleRepository repository){
        this.repository = repository;
    }

    public Rule getRule(String group, String name) {
        Rule rule = repository.findByGroupAndName(group, name); 
        return rule;
    }

    public List<Rule> listRules(String group){
        List<Rule> rules = repository.findByGroup(group);
        return rules;
    }

    public List<Rule> listRules(){
        List<Rule> rules = repository.findAll();
        return rules;
    }

    public boolean createRule(Rule rule){
        try{
            if(getRule(rule.getGroup(), rule.getName()) != null){
                throw new Exception(String.format("Rule with name %s in group %s alread exists!", rule.getName(), rule.getGroup()));
            }
            //Rule rule = objectMapper.readValue(json, Rule.class);
            repository.save(rule);
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean updateRule(String group, String name, Rule rule){
        try{
            Rule originalRule = getRule(group, name);
            if(rule.getSalience() != null){
                originalRule.setSalience(rule.getSalience());
            }
            if(rule.getCondition() != "" || rule.getCondition() != null){
                originalRule.setCondition(rule.getCondition());
            }
            if(rule.getAction() != "" || rule.getAction() != null){
                originalRule.setAction(rule.getAction());
            }
            if(rule.getComments() != "" || rule.getComments() != null){
                originalRule.setComments(rule.getComments());
            }

            repository.save(originalRule);
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteRule(String group, String name){
        try{
            repository.deleteByGroupAndName(group, name);
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}
