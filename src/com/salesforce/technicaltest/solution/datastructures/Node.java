package com.salesforce.technicaltest.solution.datastructures;

/**
 * Created by Prakash on 3/18/2017.
 * This class contain data structure defined for each folder NODE
 * 1. Every Node will have parent except root node
 * 2. Child/Directories. Hashed by name and value is pointer to child
 * 3. Abstraction
 */
class Node {

    Node parent;
    String name;
    TreeMapImpl<String, Node> directories;

    public Node(Node parent, String name){
        this.parent = parent;
        this.name = name;
        directories = new TreeMapImpl<>();
    }
}
