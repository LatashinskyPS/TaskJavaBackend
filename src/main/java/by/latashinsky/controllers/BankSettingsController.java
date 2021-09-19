package by.latashinsky.controllers;

import by.latashinsky.entities.Bank;
import by.latashinsky.factory.RepositoryFactory;
import by.latashinsky.fix.FixInput;
import by.latashinsky.repositories.MyRepository;
import by.latashinsky.utils.Confirms;

public class BankSettingsController extends BaseSettingsController<Bank> {
    private static BankSettingsController bankSettingsController;
    protected MyRepository<Bank> myRepository = (MyRepository<Bank>) new RepositoryFactory().getRepository(Bank.class);

    private BankSettingsController() {
    }

    public static BankSettingsController getInstance() {
        if (bankSettingsController == null) {
            bankSettingsController = new BankSettingsController();
        }
        return bankSettingsController;
    }

    public void update(Bank bank) {
        FixInput in = FixInput.getInstance();
        String str;
        while (true) {
            str = in.next();
            if ("n".equals(str)) {
                break;
            }
            if ("y".equals(str)) {
                bank.editName();
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
                bank.editUsualCommission();
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
                bank.editLegalCommission();
                break;
            }
            System.out.println("Invalid input!");
            return;
        }
        myRepository.save(bank);
    }

    @Override
    public boolean delete(Bank bank) {

        System.out.println(bank);
        if (Confirms.confirm()) {
            myRepository.delete(bank);
            return true;
        }
        return false;
    }
}
