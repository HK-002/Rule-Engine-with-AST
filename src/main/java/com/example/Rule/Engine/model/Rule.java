package com.example.Rule.Engine.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rules")
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_string")
    private String ruleString;

    @Column(name = "ast_structure", columnDefinition = "TEXT")
    private String astStructure;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleString() {
        return ruleString;
    }

    public void setRuleString(String ruleString) {
        this.ruleString = ruleString;
    }

    public String getAstStructure() {
        return astStructure;
    }

    public void setAstStructure(String astStructure) {
        this.astStructure = astStructure;
    }
}
