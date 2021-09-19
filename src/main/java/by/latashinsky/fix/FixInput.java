package by.latashinsky.fix;

import java.util.Scanner;

public class FixInput {
    private static FixInput fixInput;
    private final Scanner in = new Scanner(System.in).useDelimiter("\n");
    private String[] commands;
    public int currentSize;

    private FixInput() {
    }

    public static FixInput getInstance() {
        if (fixInput == null) {
            fixInput = new FixInput();
        }
        return fixInput;
    }

    public void nextLine() {
        String str = in.next();
        commands = str.split("[ ]+");
        currentSize = commands.length;
    }

    public void nextLine(String str) {
        commands = str.split("[ ]+");
        currentSize = commands.length;
    }

    public String next() {
        if (currentSize == 0) {
            return null;
        }
        return commands[commands.length - (currentSize--)];
    }
}
