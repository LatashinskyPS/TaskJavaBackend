package by.latashinsky.repositories;

import by.latashinsky.entities.Bank;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BankRepositoryTest {

    String name;
    int id;
    boolean deleteAfter;

    @Before
    public void createEntity() {
        Bank bank = BankRepository.getInstance().findById(1);
        if (bank == null) {
            bank = new Bank();
            bank.setName("grsu");
            bank.setLegalCommission(new BigDecimal("12.3"));
            bank.setUsualCommission(new BigDecimal("8.3"));
            BankRepository.getInstance().save(bank);
            name = "grsu";
            id = bank.getId();
            deleteAfter = true;
        } else {
            name = bank.getName();
            id = bank.getId();
        }
    }

    @Test
    public void getInstance() {
        assertEquals(BankRepository.getInstance(),
                BankRepository.getInstance());
    }

    @Test
    public void findByName() {
        assertNotNull("не найден объект", BankRepository.getInstance().findByName(name));
    }

    @Test
    public void findById() {
        assertNotNull(BankRepository.getInstance().findById(id));
    }

    @Test
    public void delete() {
        Bank bank = new Bank();
        BankRepository.getInstance().save(bank);
        int id = bank.getId();
        BankRepository.getInstance().delete(BankRepository.getInstance().findById(id));
        assertNull(BankRepository.getInstance().findById(id));
    }

    @After
    public void createEntityBefore() {
        if (deleteAfter) {
            BankRepository.getInstance().delete(BankRepository.getInstance().findById(id));
        }
    }
}