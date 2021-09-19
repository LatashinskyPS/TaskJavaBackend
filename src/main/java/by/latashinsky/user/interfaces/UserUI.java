package by.latashinsky.user.interfaces;

import by.latashinsky.controllers.UserController;
import by.latashinsky.fix.FixInput;

public class UserUI {
    static UserController userController = UserController.getInstance();
    static FixInput in = FixInput.getInstance();

    public static void run() {
        String command = in.next();
        userController.attemptToExecuteTheCommand(command);
    }
}
