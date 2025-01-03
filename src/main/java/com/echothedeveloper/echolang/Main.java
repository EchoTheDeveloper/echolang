package com.echothedeveloper.echolang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.echothedeveloper.utils.CompareMethods;

public class Main {
    public static void main(String[] args) throws IOException {
        String interpreterCommands[] = {
                "--quit", "--about", "--update"
        };

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        var running = true;
        while (running) {
            System.out.println("Echolang Interpreterr >> V1.0.0 >> ");
            String cmd = buffer.readLine();

            if (CompareMethods.strInArray(interpreterCommands, cmd)) {
                switch (cmd) {
                    case "--quit":
                        System.out.println("Exiting Echolang Interpreter");
                        running = false;
                        break;
                    case "--about":
                        System.out.println("Echolang is a simple language created by echothedeveloper\n" +
                                "You are running Echolang Version 1.0.0");

                }
            }

        }
    }
}