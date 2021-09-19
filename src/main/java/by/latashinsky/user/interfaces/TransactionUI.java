package by.latashinsky.user.interfaces;

import by.latashinsky.controllers.TransactionController;
import by.latashinsky.fix.FixInput;

import java.util.Scanner;

public class TransactionUI {
    static TransactionController transactionController = TransactionController.getInstance();
    static FixInput in = FixInput.getInstance();

    public static void run() {
            String command = in.next();
            transactionController.attemptToExecuteTheCommand(command);
    }
}
