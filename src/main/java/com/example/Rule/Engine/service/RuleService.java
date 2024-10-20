package com.example.Rule.Engine.service;

import com.example.Rule.Engine.model.Node;
import com.example.Rule.Engine.model.RuleRequest;
import com.example.Rule.Engine.model.UserData;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Service
public class RuleService {

    // Method to evaluate the rule
    public boolean evaluateRule(RuleRequest ruleRequest) {
        // Convert UserData to Map
        Map<String, Object> userDataMap = convertUserDataToMap(ruleRequest.getUserData());

        // Create AST from the rule string
        Node ast = createASTFromRuleString(ruleRequest.getRuleString());

        // Now use the AST to evaluate the rule
        return evaluate(userDataMap, ast);
    }

    // Method to create AST from rule string
    private Node createASTFromRuleString(String ruleString) {
        // Simple implementation of parsing the rule string into an AST
        // Remove unnecessary spaces
        ruleString = ruleString.replaceAll("\\s+", " ");

        // Split by operators
        String[] parts = ruleString.split("(?<=\\)) (?=OR|AND)| (?=OR|AND)");

        Node root = null;
        Stack<Node> stack = new Stack<>();
        String operator = "";

        for (String part : parts) {
            if (part.equals("AND") || part.equals("OR")) {
                operator = part;
            } else {
                Node currentNode = new Node("operand", part.trim());
                if (root == null) {
                    root = currentNode; // First operand
                } else {
                    Node newNode = new Node("operator", operator, root, currentNode);
                    root = newNode; // Update root to new node
                }
            }
        }

        return root; // Return the constructed AST
    }

    // Convert UserData to Map
    private Map<String, Object> convertUserDataToMap(UserData userData) {
        Map<String, Object> userDataMap = new HashMap<>();
        userDataMap.put("age", userData.getAge());
        userDataMap.put("department", userData.getDepartment());
        userDataMap.put("salary", userData.getSalary());
        userDataMap.put("experience", userData.getExperience());
        return userDataMap;
    }

    // Placeholder for evaluate method
    private boolean evaluate(Map<String, Object> userDataMap, Node ast) {
        // Implement your evaluation logic here based on the AST
        return true; // Placeholder
    }

    // Method to parse rule to AST (for createRule)
    public Node parseRuleToAST(String ruleString) {
        return createASTFromRuleString(ruleString);
    }
}
