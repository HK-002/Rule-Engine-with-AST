package com.example.Rule.Engine.model;

public class RuleRequest {
    private String ruleString;
    private UserData userData; 

    // Getters and Setters
    public String getRuleString() {
        return ruleString;
    }

    public void setRuleString(String ruleString) {
        this.ruleString = ruleString;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
