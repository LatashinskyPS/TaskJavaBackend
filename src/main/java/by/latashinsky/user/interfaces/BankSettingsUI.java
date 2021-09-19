package by.latashinsky.user.interfaces;

import by.latashinsky.controllers.BankController;
import by.latashinsky.controllers.BankSettingsController;
import by.latashinsky.entities.Bank;
import by.latashinsky.fix.FixInput;

import java.util.Scanner;

public class BankSettingsUI {
    static BankSettingsController bankSettingsController = BankSettingsController.getInstance();
    static FixInput in = FixInput.getInstance();

    public static void run(Bank bank) {
        String command = in.next();
        bankSettingsController.attemptToExecuteTheCommand(command, bank);
    }
}
