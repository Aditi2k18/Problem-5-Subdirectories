package com.salesforce.technicaltest.solution.datastructures;

import com.salesforce.technicaltest.solution.expections.NoUpRootDirectoryException;

import java.util.Iterator;

/**
 * Created by Prakash on 3/18/2017.
 * Class available to client for implementing file structure
 * 1. if parent of currentDirectory is null then is root directory
 */
public class DoublyLinkedListImpl {

    public Node currentDirectory;

    public DoublyLinkedListImpl(){
        currentDirectory = new Node(null, "root");
    }

    public void dir(){
        StringBuilder compact = new StringBuilder();
        StringBuilder open = new StringBuilder();
        Iterator<String> it = currentDirectory.directories.keySet().iterator();
        while (it.hasNext()){
            open.append(it.next() + "    ");
        }

        Node temp = currentDirectory;
        while(temp.parent!=null){
            compact.insert(0, "\\"+temp.name);
            temp = temp.parent;
        }

        if(open.length() < 1 ) open.append("No subdirectories ");
        System.out.println("Directory of root" + compact.toString()  + ": ");
        System.out.println(open + " ");
    }

    /**
     * One root up OR log exception
     */
    public void up(){
        if(currentDirectory.parent!=null) {
            currentDirectory = currentDirectory.parent;
        }else{
            try {
                throw new NoUpRootDirectoryException();
            } catch (NoUpRootDirectoryException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Create a child node under current Node.
     * @param name
     */
    public void mkdir(String name){
        Node child = new Node(currentDirectory, name);
        currentDirectory.directories.put(child.name, child);
    }

    /**
     * Gets the desired folder pointer or exception is logged
     * @param name
     */
    public void cd(String name){
        if( currentDirectory.directories!=null && currentDirectory.directories.get(name)!=null)
            currentDirectory = (Node) currentDirectory.directories.get(name);
    }

}
