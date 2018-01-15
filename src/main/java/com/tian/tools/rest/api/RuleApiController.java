package com.tian.tools.rest.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.tian.tools.controller.RuleController;
import com.tian.tools.model.Rule;
import com.tian.tools.model.RuleRepository;

@RestController
@RequestMapping("rule/")
public class RuleApiController implements InitializingBean{
    @Autowired
    private RuleRepository repository;
    private RuleController ruleController;

    @Override
    public void afterPropertiesSet() throws Exception {
        ruleController = new RuleController(repository);
    }

    @RequestMapping(value = "/show/{group}/{name}", method = RequestMethod.GET)
    public Rule showRule(@PathVariable("group") String group, 
                         @PathVariable("name") String name) {
        return ruleController.getRule(group, name);
    }

    @RequestMapping(value = "/show/{group}", method = RequestMethod.GET)
    public List<Rule> showRulesByGroup(@PathVariable("group") String group) {
        return ruleController.listRules(group);
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public List<Rule> showAll() {
        return ruleController.listRules();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody Rule rule, 
                                         UriComponentsBuilder ucBuilder) {

        boolean result = ruleController.createRule(rule);
        if (result) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/{group}/{name}").buildAndExpand(rule.getGroup(), rule.getName()).toUri());
            return new ResponseEntity<String>(String.format("Successfully created rule with group: %s and name : %s \n", rule.getGroup(), rule.getName()),headers, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<String>(String.format("Error creating rule with with group: %s and name: %s. \n", rule.getGroup(), rule.getName()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/{group}/{name}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("group") String group, 
                                         @PathVariable("name") String name, 
                                         @RequestBody Rule rule,
                                         UriComponentsBuilder ucBuilder) {
        
        boolean result = ruleController.updateRule(group, name, rule);
        if (result) {
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(ucBuilder.path("/{group}/{name}").buildAndExpand(rule.getGroup(), rule.getName()).toUri());
            return new ResponseEntity<String>(String.format("Successfully updated rule with group: %s and name : %s \n", group, name),headers, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>(String.format("Error creating rule with with group: %s and name: %s. \n", group, name),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{group}/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("group") String group, 
                                         @PathVariable("name") String name) {
        boolean result = ruleController.deleteRule(group, name);
        if (result) {
            return new ResponseEntity<String>(String.format("Successfully deleted rule with group: %s and name: %s \n", group, name),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>(String.format("Error deleting rule with group: %s and name: %s. \n", group, name),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
