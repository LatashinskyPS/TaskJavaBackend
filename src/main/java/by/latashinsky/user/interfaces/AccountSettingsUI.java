package by.latashinsky.user.interfaces;

import by.latashinsky.controllers.AccountSettingsController;
import by.latashinsky.controllers.UserSettingsController;
import by.latashinsky.entities.Account;
import by.latashinsky.entities.User;

import java.util.Scanner;

public class AccountSettingsUI {
    static AccountSettingsController accountSettingsController = AccountSettingsController.getInstance();
    static Scanner in = new Scanner(System.in).useDelimiter("\n");

    public static void run(Account account) {
        while (true) {
            System.out.print("/banks/" + account.getId() + ">>");
            String command = in.next();
            if (accountSettingsController.attemptToExecuteTheCommand(command, account)) {
                break;
            }
        }
    }

}
