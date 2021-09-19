package by.latashinsky.repositories;

import by.latashinsky.HibernateSessionFactory;
import by.latashinsky.entities.Account;
import by.latashinsky.entities.Bank;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

public class AccountRepository implements MyRepository<Account> {

    private final SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    private static AccountRepository accountRepository;

    private AccountRepository() {

    }

    public static AccountRepository getInstance() {
        if (accountRepository == null) {
            accountRepository = new AccountRepository();
        }
        return accountRepository;
    }

    @Override
    public Account findById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Account account = session.get(Account.class, id);
        session.getTransaction().commit();
        session.close();
        return account;
    }

    @Override
    public List<Account> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Account> accounts = session.createQuery("FROM Account").list();
        session.getTransaction().commit();
        session.close();
        return accounts;
    }

    @Override
    public void save(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        if (account.getId() != 0) {
            session.update(account);
        } else {
            session.save(account);
        }
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(account);
        session.getTransaction().commit();
        session.close();
    }
}
