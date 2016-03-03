package nl.mawoo.migratejs;

import nl.mawoo.migratejs.scriptengine.ScriptHandler;

import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The main class to run MigrateJS
 */
public class Main {
    public static void main(String... args) {

        ScriptHandler scriptHandler = new ScriptHandler();

        if(args.length > 0){

            String path = args[0];

            try {
                scriptHandler.fileReader(path);
            } catch (FileNotFoundException | ScriptException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Mawoo MigrateJS - Migrate data easily with javascript! (c) copyright 2016 \n");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while(true) {
                try {
                    System.out.print(">");
                    String input = br.readLine();

                    scriptHandler.stringReader(input);
                } catch (IOException | ScriptException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
