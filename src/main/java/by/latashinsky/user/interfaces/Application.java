package by.latashinsky.user.interfaces;

import by.latashinsky.controllers.CommandController;
import by.latashinsky.fix.FixInput;

import java.util.Scanner;

public class Application {
    static CommandController commandController = CommandController.getInstance();
    static FixInput in = FixInput.getInstance();

    public static void run() {
        while (true) {
            System.out.print(">>");
            in.nextLine();
            String command = in.next();
            if (commandController.attemptToExecuteTheCommand(command)) {
                break;
            }
        }
        System.out.print(">> And of work.");
    }
}
