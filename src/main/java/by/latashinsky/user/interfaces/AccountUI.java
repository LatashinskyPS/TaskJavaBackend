package by.latashinsky.user.interfaces;

import by.latashinsky.controllers.AccountController;
import by.latashinsky.controllers.BankController;
import by.latashinsky.fix.FixInput;

import java.util.Scanner;

public class AccountUI {
    static AccountController accountController = AccountController.getInstance();
    static FixInput in = FixInput.getInstance();

    public static void run() {
        String command = in.next();
        accountController.attemptToExecuteTheCommand(command);
    }
}