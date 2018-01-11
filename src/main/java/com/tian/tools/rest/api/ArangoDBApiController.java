package com.tian.tools.rest.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tian.tools.controller.ArangoDBController;


@RestController
@RequestMapping("arangodb/")
public class ArangoDBApiController {

    @RequestMapping(value = "/database/{name}", method = RequestMethod.POST)
    public boolean createDatabase(@PathVariable String name) {
        return ArangoDBController.createDatabase(name);
    }
    @RequestMapping(value = "/user/{username}/{password}", method = RequestMethod.POST)
    public boolean createUser(@PathVariable("username") String username,@PathVariable("password") String password) {
        return ArangoDBController.createUser(username, password);
    }
}
