package by.latashinsky.user.interfaces;

import by.latashinsky.controllers.AccountSettingsController;
import by.latashinsky.controllers.UserSettingsController;
import by.latashinsky.entities.Account;
import by.latashinsky.entities.User;
import by.latashinsky.fix.FixInput;

public class AccountSettingsUI {
    static AccountSettingsController accountSettingsController = AccountSettingsController.getInstance();
    static FixInput in = FixInput.getInstance();

    public static void run(Account account) {
        String command = in.next();
        accountSettingsController.attemptToExecuteTheCommand(command, account);
    }
}
