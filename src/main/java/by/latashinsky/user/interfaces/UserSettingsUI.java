package by.latashinsky.user.interfaces;

import by.latashinsky.controllers.BankSettingsController;
import by.latashinsky.controllers.UserSettingsController;
import by.latashinsky.entities.Bank;
import by.latashinsky.entities.User;
import by.latashinsky.fix.FixInput;

import java.util.Scanner;

public class UserSettingsUI {
    static UserSettingsController userSettingsController = UserSettingsController.getInstance();
    static FixInput in = FixInput.getInstance();

    public static void run(User user) {
            String command = in.next();
            userSettingsController.attemptToExecuteTheCommand(command, user);
    }
}
