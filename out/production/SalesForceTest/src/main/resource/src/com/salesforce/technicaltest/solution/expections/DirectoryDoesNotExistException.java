package com.salesforce.technicaltest.solution.expections;

/**
 * Created by Prakash on 3/18/2017.
 */
public class DirectoryDoesNotExistException extends Exception {

    public static final String DEFAULT_ERROR = "Subdirectory does not exist ";

    public DirectoryDoesNotExistException(){
        super(DEFAULT_ERROR);
    }
}