package by.latashinsky.user.interfaces;

import by.latashinsky.controllers.UserSettingsController;
import by.latashinsky.controllers.UserTransactionsController;
import by.latashinsky.entities.User;
import by.latashinsky.fix.FixInput;

import java.util.Scanner;

public class UserTransactionUI {
    static UserTransactionsController userTransactionsController = UserTransactionsController.getInstance();
    static FixInput in = FixInput.getInstance();

    public static void run(User user) {
            String command = in.next();
            userTransactionsController.attemptToExecuteTheCommand(command, user);
    }
}
