package com.tian.tools.controller;

import java.util.concurrent.atomic.AtomicLong;
import com.tian.tools.model.Rule;

public class RulesController {

    private static final String template = "The sample rule: %s!";
    private static final AtomicLong counter = new AtomicLong();

    public static Rule getRule(Integer id) {
        return new Rule(counter.incrementAndGet(),
                            String.format(template, id));
    }
}
