package com.salesforce.technicaltest.solution.main;

import com.salesforce.technicaltest.solution.datastructures.DoublyLinkedListImpl;

import java.io.*;
import java.nio.file.Files;
import java.util.StringTokenizer;

/**
 * Created by Prakash on 3/18/2017.
 */
public class Main {

    public static final String DIR = "dir";
    public static final String MKDIR = "mkdir";
    public static final String CD = "cd";
    public static final String UP = "up";

    static DoublyLinkedListImpl fileSystem = new DoublyLinkedListImpl();


    public static void main(String args[]) throws IOException {
        initOutputWriter();
        System.out.println("Problem 5 by team X ");

        // Read input command file
        String[] lines = Files.readAllLines(new File("prog5.dat").toPath()).toArray(new String[0]);
        int commands = lines.length, i=0;

        while(i<commands){
            String command = lines[i];
            System.out.println("Command: " + command + " ");

            if ( command.startsWith(DIR) ){
                fileSystem.dir();
            }else if ( command.startsWith(MKDIR) ){
                fileSystem.mkdir(getParam(command));
            }else if ( command.startsWith(CD) ){
                fileSystem.cd(getParam(command));
            }else if ( command.startsWith(UP) ){
                fileSystem.up();
            }
            i++;
        }

        System.out.print("End of problem 5 by team X ");
    }

    private static void initOutputWriter() {
        PrintStream out;
        try {
            out = new PrintStream(new FileOutputStream("prog5.out"));
            System.setOut(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Extract the 2nd param from line
     * @param str
     * @return
     */
    static String getParam(String str){
        StringTokenizer st = new StringTokenizer(str);
        st.nextToken();
        return st.nextToken();
    }
}
