package com.tian.tools.model;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.tian.tools.model.Rule;

public interface RuleRepository extends MongoRepository<Rule, String> {
    Rule findByGroupAndName(String group, String name);
    List<Rule> findByGroup(String group);
    List<Rule> findAll();
    Long deleteByGroupAndName(String group, String name);
}
