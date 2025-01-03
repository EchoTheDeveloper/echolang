package com.echothedeveloper.echolang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.echothedeveloper.utils.CompareMethods;

import static com.echothedeveloper.echolang.interpreter.shell.Updater.checkUpdates;

public class Main {
    public static int[] CURRENT_VERSION = {0, 0, 0};

    public static void main(String[] args) throws IOException {
        String interpreterCommands[] = {
                "--quit", "--about", "--version"
        };

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        var running = true;
        while (running) {
            System.out.println("Echolang Interpreterr >> ");
            String cmd = buffer.readLine();

            if (CompareMethods.strInArray(interpreterCommands, cmd)) {
                switch (cmd) {
                    case "--quit":
                        System.out.println("Exiting Echolang Interpreter");
                        running = false;
                        break;
                    case "--about":
                        System.out.println("Echolang is a simple language created by echothedeveloper\n" +
                                "You are running Echolang Version " + CURRENT_VERSION[0] + "." + CURRENT_VERSION[1] + "." + CURRENT_VERSION[2]);
                        break;
                    case "--version":
                        checkUpdates();
                }
            }

        }
    }
}