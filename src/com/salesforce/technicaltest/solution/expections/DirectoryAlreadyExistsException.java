package com.salesforce.technicaltest.solution.expections;

/**
 * Created by Prakash on 3/18/2017.
 */
public class DirectoryAlreadyExistsException extends Exception {

    public static final String DEFAULT_ERROR = "Subdirectory already exists ";

    public DirectoryAlreadyExistsException(){
        super(DEFAULT_ERROR);
    }
}
