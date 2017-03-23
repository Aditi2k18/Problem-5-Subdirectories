package com.salesforce.technicaltest.solution.expections;

/**
 * Created by Prakash on 3/18/2017.
 */
public class NoUpRootDirectoryException extends Exception {

    public static final String DEFAULT_ERROR = "Cannot move up from root directory ";

    public NoUpRootDirectoryException(){
        super(DEFAULT_ERROR);
    }
}
