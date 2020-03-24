package com.lits.console;

import com.lits.model.config.DbConnection;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {

        System.out.println();
        System.out.println( "Application starting" );

        for (;;) {
            ConsoleApp.launch(new DbConnection());
        }
    }
}

