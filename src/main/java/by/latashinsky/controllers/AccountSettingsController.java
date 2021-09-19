package by.latashinsky.controllers;

import by.latashinsky.entities.Account;
import by.latashinsky.entities.Bank;
import by.latashinsky.factory.RepositoryFactory;
import by.latashinsky.repositories.MyRepository;
import by.latashinsky.utils.Confirms;

import java.util.Scanner;

public class AccountSettingsController extends BaseSettingsController<Account> {
    private static AccountSettingsController accountSettingsController;
    protected MyRepository<Account> myRepository = (MyRepository<Account>) new RepositoryFactory().getRepository(Account.class);

    private AccountSettingsController() {
    }

    public static AccountSettingsController getInstance() {
        if (accountSettingsController == null) {
            accountSettingsController = new AccountSettingsController();
        }
        return accountSettingsController;
    }
    @Override
    public void update(Account account) {
        System.out.println(account);
        System.out.println("Are you want to edit bank(y/n)?");
        Scanner in = new Scanner(System.in).useDelimiter("\n");
        String str;
        while (true) {
            str = in.next();
            if ("n".equals(str)) {
                break;
            }
            if ("y".equals(str)) {
                account.editBank();
                break;
            }
        }
        while (true) {
            System.out.println("Are you want to user(y/n)?");
            str = in.next();
            if ("n".equals(str)) {
                break;
            }
            if ("y".equals(str)) {
                account.editUser();
                break;
            }
        }
        while (true) {
            System.out.println("Are you want to balance(y/n)?");
            str = in.next();
            if ("n".equals(str)) {
                break;
            }
            if ("y".equals(str)) {
                account.editBalance();
                break;
            }
        }
        while (true) {
            System.out.println("Are you want to currency(y/n)?");
            str = in.next();
            if ("n".equals(str)) {
                break;
            }
            if ("y".equals(str)) {
                account.editCurrency();
                break;
            }
        }
        myRepository.save(account);
    }

    @Override
    public boolean delete(Account account) {

        System.out.println(account);
        if (Confirms.confirm()) {
            myRepository.delete(account);
            return true;
        }
        return false;
    }
}
