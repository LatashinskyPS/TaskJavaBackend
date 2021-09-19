package by.latashinsky.utils;

import by.latashinsky.fix.FixInput;

import java.util.Scanner;

public class Confirms {
    public static boolean confirm() {
        FixInput in = FixInput.getInstance();
        String str;
        while (true) {
            str = in.next();
            if ("n".equals(str)) {
                break;
            }
            if ("y".equals(str)) {
                return true;
            }
            System.out.println("Invalid input!");
            return false;
        }
        return false;
    }
}
