package com.example.Rule.Engine.model;

public class Node {
    private String type; 
    private String value; 
    //child nodes
    public Node left; 
    public Node right;

    // Constructors 
    public Node(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public Node(String type, String value, Node left, Node right) {
        this.type = type;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    // Getters
    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    // Setters
    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
