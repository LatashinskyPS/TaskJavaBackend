package by.latashinsky.controllers;

import by.latashinsky.entities.Bank;
import by.latashinsky.factory.RepositoryFactory;
import by.latashinsky.models.MyListConverter;
import by.latashinsky.repositories.MyRepository;
import by.latashinsky.user.interfaces.BankSettingsUI;
import by.latashinsky.utils.SelectHelpUtil;

public class BankController extends BaseShowAndCreateController<Bank> {
    private static BankController bankController;
    protected MyRepository<Bank> myRepository = (MyRepository<Bank>) new RepositoryFactory().getRepository(Bank.class);

    private BankController() {
    }

    public static BankController getInstance() {
        if (bankController == null) {
            bankController = new BankController();
        }
        return bankController;
    }

    public void create() {
        Bank bank = new Bank();
        if (bank.editName() && bank.editLegalCommission() && bank.editUsualCommission())
            myRepository.save(bank);
        else System.out.println("Invalid input (name legalCommission usualCommission)");
    }

    public void read() {
        Bank bank = SelectHelpUtil.selectBank();
        if (bank != null) BankSettingsUI.run(bank);
    }

    public void show() {
        System.out.print(MyListConverter.convert(myRepository.findAll()));
    }
}
