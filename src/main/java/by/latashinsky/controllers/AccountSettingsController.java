package by.latashinsky.controllers;

import by.latashinsky.entities.Account;
import by.latashinsky.entities.Bank;
import by.latashinsky.factory.RepositoryFactory;
import by.latashinsky.fix.FixInput;
import by.latashinsky.repositories.MyRepository;
import by.latashinsky.utils.Confirms;


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
        FixInput in = FixInput.getInstance();
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
            System.out.println("Invalid input!");
            return;
        }
        while (true) {
            str = in.next();
            if ("n".equals(str)) {
                break;
            }
            if ("y".equals(str)) {
                account.editUser();
                break;
            }
            System.out.println("Invalid input!");
            return;
        }
        while (true) {
            str = in.next();
            if ("n".equals(str)) {
                break;
            }
            if ("y".equals(str)) {
                account.editBalance();
                break;
            }
            System.out.println("Invalid input!");
            return;
        }
        while (true) {
            str = in.next();
            if ("n".equals(str)) {
                break;
            }
            if ("y".equals(str)) {
                account.editCurrency();
                break;
            }
            System.out.println("Invalid input!");
            return;
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
