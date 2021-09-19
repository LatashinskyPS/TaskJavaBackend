package by.latashinsky.utils;

import by.latashinsky.entities.Account;
import by.latashinsky.entities.Bank;
import by.latashinsky.entities.User;
import by.latashinsky.factory.RepositoryFactory;
import by.latashinsky.fix.FixInput;
import by.latashinsky.models.Constants;
import by.latashinsky.repositories.MyRepository;
import by.latashinsky.user.interfaces.BankSettingsUI;
import by.latashinsky.user.interfaces.UserSettingsUI;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SelectHelpUtil {
    public static Bank selectBank() {
        MyRepository<Bank> myRepository = (MyRepository<Bank>) new RepositoryFactory().getRepository(Bank.class);
        FixInput in = FixInput.getInstance();
        while (true) {
            String str = in.next();
            if (Pattern.matches(Constants.PATTERN_INT, str)) {
                int index = Integer.parseInt(str);
                Bank bank = myRepository.findById(index);
                if (bank != null) {
                    return bank;
                }
            }
            if ("0".equals(str)) break;
            System.out.println("Invalid input!");
            return null;
        }
        return null;
    }

    public static User selectUser() {
        MyRepository<User> myRepository = (MyRepository<User>) new RepositoryFactory().getRepository(User.class);
        FixInput in = FixInput.getInstance();
        while (true) {
            String str = in.next();
            if (Pattern.matches(Constants.PATTERN_INT, str)) {
                int index = Integer.parseInt(str);
                User user = myRepository.findById(index);
                if (user != null) {
                    return user;
                }
            }
            if ("0".equals(str)) break;
            System.out.println("Invalid input!");
            return null;
        }
        return null;
    }

    public static Account selectAccount() {
        MyRepository<Account> myRepository = (MyRepository<Account>) new RepositoryFactory().getRepository(Account.class);
        FixInput in = FixInput.getInstance();
        while (true) {
            String str = in.next();
            if (Pattern.matches(Constants.PATTERN_INT, str)) {
                int index = Integer.parseInt(str);
                Account account = myRepository.findById(index);
                if (account != null) {
                    return account;
                }
            }
            if ("0".equals(str)) break;
            System.out.println("Invalid input!");
            return null;
        }
        return null;
    }
}
