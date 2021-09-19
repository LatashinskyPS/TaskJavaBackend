package by.latashinsky.controllers;

import by.latashinsky.entities.Bank;
import by.latashinsky.fix.FixInput;
import by.latashinsky.repositories.BankRepository;
import org.junit.Assert;
import org.junit.Test;

class BankControllerTest {
    @Test
    public void create() {
        FixInput in = FixInput.getInstance();
        BankController bankController = BankController.getInstance();
        BankRepository bankRepository = BankRepository.getInstance();
        in.nextLine("create testCreate 12.2 13.2");
        bankController.create();
        Bank bank = bankRepository.findByName("testCreate");
        Assert.assertNotNull(bank);
        Assert.assertEquals("testCreate", bank.getName());
    }
}