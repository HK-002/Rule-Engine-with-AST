package com.example.Rule.Engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Rule.Engine.model.Node;
import com.example.Rule.Engine.model.RuleRequest;
import com.example.Rule.Engine.service.RuleService;

import java.util.List;

@RestController
@RequestMapping("/rules") // requests to /rules
public class RuleController {

    @Autowired
    private RuleService ruleService;

    // POST /rules/createRule
    @PostMapping("/createRule")
    public Node createRule(@RequestBody String ruleString) {
        return ruleService.parseRuleToAST(ruleString);
    }

    // POST /rules/combineRules
    @PostMapping("/combineRules")
    public Node combineRules(@RequestBody List<String> ruleStrings) {
        if (ruleStrings == null || ruleStrings.isEmpty()) {
            throw new IllegalArgumentException("No rules provided to combine.");
        }

        Node combinedAST = null;

        // Iterate over the list of rule strings
        for (String ruleString : ruleStrings) {
            Node currentAST = ruleService.parseRuleToAST(ruleString);

            if (combinedAST == null) {
                combinedAST = currentAST; 
            } else {
            
                combinedAST = combineASTs(combinedAST, currentAST);
            }
        }

        return combinedAST; 
    }

    private Node combineASTs(Node ast1, Node ast2) {
        
        Node combined = new Node("operator", "OR"); 
        
        combined.left = ast1;
        combined.right = ast2;

        return combined;
    }

    // POST /rules/evaluateRule
    @PostMapping("/evaluateRule")
    public ResponseEntity<Boolean> evaluateRule(@RequestBody RuleRequest ruleRequest) {
        
        boolean result = ruleService.evaluateRule(ruleRequest);
        
        
        return ResponseEntity.ok(result);
    }

    @GetMapping("/test")
    public String test() {
        return "Controller is working!";
    }
}
