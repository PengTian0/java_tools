package com.tian.tools.rest.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tian.tools.controller.RulesController;
import com.tian.tools.model.Rule;


@RestController
@RequestMapping("rules/")
public class RulesApiController {

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public Rule showRule(@PathVariable Integer id) {
        return RulesController.getRule(id);
    }
}
