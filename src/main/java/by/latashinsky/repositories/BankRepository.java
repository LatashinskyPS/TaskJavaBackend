package by.latashinsky.repositories;

import by.latashinsky.HibernateSessionFactory;
import by.latashinsky.entities.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class BankRepository implements MyRepository<Bank> {
    private final SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
    private static BankRepository bankRepository;

    private BankRepository() {

    }

    public static BankRepository getInstance() {
        if (bankRepository == null) {
            bankRepository = new BankRepository();
        }
        return bankRepository;
    }

    public Bank findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Bank> query = session.createQuery("from Bank b where b.name= :bankName");
        query.setParameter("bankName", name);
        Optional<Bank> bank = query.stream().findFirst();
        session.getTransaction().commit();
        session.close();
        return bank.orElse(null);
    }

    @Override
    public Bank findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Bank bank = session.get(Bank.class, id);
        session.getTransaction().commit();
        session.close();
        return bank;
    }

    @Override
    public List<Bank> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Bank> banks = session.createQuery("FROM Bank ").list();
        session.getTransaction().commit();
        session.close();
        return banks;
    }

    @Override
    public void save(Bank bank) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        if (bank.getId() != 0) {
            session.update(bank);
        } else {
            session.save(bank);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Bank bank) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(bank);
        session.getTransaction().commit();
        session.close();
    }
}
