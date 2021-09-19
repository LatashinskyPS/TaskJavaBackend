package by.latashinsky.controllers;

import by.latashinsky.entities.Account;
import by.latashinsky.entities.Bank;
import by.latashinsky.entities.User;
import by.latashinsky.models.Constants;
import by.latashinsky.models.MyListConverter;
import by.latashinsky.models.TransactionManager;
import by.latashinsky.repositories.TransactionRepository;
import by.latashinsky.user.interfaces.BankSettingsUI;
import by.latashinsky.user.interfaces.UserTransactionUI;
import by.latashinsky.utils.SelectHelpUtil;
import org.hibernate.Transaction;

import javax.transaction.UserTransaction;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TransactionController implements Controller {
    private final TransactionManager transactionManager = TransactionManager.getInstance();
    private static TransactionController transactionController;
    private final TransactionRepository transactionRepository = TransactionRepository.getInstance();

    private TransactionController() {
    }

    public static TransactionController getInstance() {
        if (transactionController == null) {
            transactionController = new TransactionController();
        }
        return transactionController;
    }

    public boolean attemptToExecuteTheCommand(String s) {
        if (s == null) {
            s = "help";
        }
        switch (s.toLowerCase(Locale.ROOT)) {
            case "exit" -> {
                return true;
            }
            case "help" -> {
                help();
                return true;
            }
            case "new" -> {
                createTransaction();
                return true;
            }
            case "show" -> {
                show();
                return true;
            }
            case "user" -> {
                read();
                return true;
            }
            default -> {
                System.out.println("Unknown command! Try help.");
                return true;
            }
        }
    }

    public void read() {
        User user = SelectHelpUtil.selectUser();
        if (user != null) UserTransactionUI.run(user);
    }

    public void show() {
        System.out.print(MyListConverter.convert(transactionRepository.findAll()));
    }

    public void createTransaction() {
        Account accountFrom = SelectHelpUtil.selectAccount();
        if (accountFrom == null) {
            return;
        }
        Account accountTo = SelectHelpUtil.selectAccount();
        if (accountTo == null) {
            return;
        }
        if (accountFrom == accountTo) {
            System.out.println("Error! Accounts equal!");
            return;
        }
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        String str;
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        do {
            str = in.next();
            if (Pattern.matches(Constants.PATTERN_DOUBLE, str)) {
                bigDecimal = new BigDecimal(str);
                break;
            }
            System.out.println("Invalid input!");
            return;
        } while (!"exit".equals(str));
        transactionManager.doTransaction(accountFrom, accountTo, bigDecimal);
    }

    @Override
    public void help() {
        System.out.println(
                """
                        user - перейти к меню для получения более подробной информации по транзакциям пользователя
                        show - вывести список всех транзкций
                        new - провести новую транзакцию
                        exit - перейти к предыдущему меню
                        help - вывести данное меню"""
        );
    }
}
