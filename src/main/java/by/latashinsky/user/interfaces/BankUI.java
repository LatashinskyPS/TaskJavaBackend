package by.latashinsky.user.interfaces;

import by.latashinsky.controllers.BankController;
import by.latashinsky.fix.FixInput;

public class BankUI {
    static BankController bankController = BankController.getInstance();
    static FixInput in = FixInput.getInstance();

    public static void run() {
        String command = in.next();
        bankController.attemptToExecuteTheCommand(command);
    }
}
