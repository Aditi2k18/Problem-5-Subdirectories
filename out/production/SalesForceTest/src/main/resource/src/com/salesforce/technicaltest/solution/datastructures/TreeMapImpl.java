package com.salesforce.technicaltest.solution.datastructures;

import com.salesforce.technicaltest.solution.expections.DirectoryAlreadyExistsException;
import com.salesforce.technicaltest.solution.expections.DirectoryDoesNotExistException;

import java.util.TreeMap;

/**
 * Created by Prakash on 3/18/2017.
 * 1. Overriding put to log exceptions
 * 2. @Override put and get to handle error case log exception
 */
public class TreeMapImpl<String ,Node> extends TreeMap {

    /**
     * Before creating new folder check if already exists or not
     * @param key
     * @param value
     * @return
     */
    @Override
    public Object put(Object key, Object value) {
        if( !super.containsKey(key) ) {
            return super.put(key, value);
        }
        else {
            try {
                throw new DirectoryAlreadyExistsException();
            } catch (DirectoryAlreadyExistsException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
    }

    /**
     * Before getting folder pointer make sure folder exists
     * @param key
     * @return
     */
    @Override
    public Object get(Object key) {
        if(super.containsKey(key)){
            return super.get(key);
        }else {
            try {
                throw new DirectoryDoesNotExistException();
            } catch (DirectoryDoesNotExistException e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
    }
}
