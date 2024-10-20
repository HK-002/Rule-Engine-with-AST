package com.example.Rule.Engine.repository;

import com.example.Rule.Engine.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {
    // Additional query
}
