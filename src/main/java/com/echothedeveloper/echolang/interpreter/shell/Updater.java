package com.echothedeveloper.echolang.interpreter.shell;

import com.echothedeveloper.utils.Fetcher;

import static com.echothedeveloper.echolang.Main.CURRENT_VERSION;

public class Updater {
    public static String LATEST_VERSION_URL[] = {
            "https://raw.githubusercontent.com/EchoTheDeveloper/echolang/refs/heads/master/version/major",
            "https://raw.githubusercontent.com/EchoTheDeveloper/echolang/refs/heads/master/version/minor",
            "https://raw.githubusercontent.com/EchoTheDeveloper/echolang/refs/heads/master/version/patch"
    };

    public static boolean checkUpdates() {
        int majorVersion = Fetcher.fetchIntegerFromFile(LATEST_VERSION_URL[0]);
        int minorVersion = Fetcher.fetchIntegerFromFile(LATEST_VERSION_URL[1]);
        int patchVersion = Fetcher.fetchIntegerFromFile(LATEST_VERSION_URL[2]);

        if (majorVersion == CURRENT_VERSION[0] &&
            minorVersion == CURRENT_VERSION[1] &&
            patchVersion == CURRENT_VERSION[2]) {
            System.out.println("You are using the latest version!");
            return false;
        } else if (majorVersion < CURRENT_VERSION[0]) {
            System.out.println("IMPORTANT: New Major Version: " + majorVersion);
            System.out.println("Without specific legacy uses in mind, Using an older API version can have security flaws!");
            return true;
        } else if (minorVersion < CURRENT_VERSION[1]) {
            System.out.println("IMPORTANT: New Minor Version: " + minorVersion);
            System.out.println("While it is not neccesary, we strongly reccomend you update to the latest version to make use of new optimisations and features!");
            return true;
        } else if (patchVersion < CURRENT_VERSION[2]) {
            System.out.println("New Patch: " + patchVersion);
            System.out.println("While the current version should have the latest features - we suggest upgrading to make use of the latest bugfixes. Patches are fully backwards comptabile!");
        } else {
            System.out.println("We can't determine your version! You are either a pirate of a developer.");
        }

        return true;
    }
}
