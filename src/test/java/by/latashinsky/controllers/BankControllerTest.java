package by.latashinsky.controllers;

import by.latashinsky.controllers.BankController;
import by.latashinsky.entities.Bank;
import by.latashinsky.fix.FixInput;
import by.latashinsky.repositories.BankRepository;
import org.junit.Assert;
import org.junit.Test;

public class BankControllerTest {
    @Test
    public void create() {
        FixInput in = FixInput.getInstance();
        BankController bankController = BankController.getInstance();
        BankRepository bankRepository = BankRepository.getInstance();
        in.nextLine("testCreate 12.2 13.2");
        Bank bank = bankRepository.findByName("testCreate");
        if (bank == null) {
            bankController.create();
        }
        Assert.assertNotNull("банк не создан",bank);
        Assert.assertEquals("testCreate", bank.getName());
    }
}