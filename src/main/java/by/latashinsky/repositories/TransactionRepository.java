package by.latashinsky.repositories;

import by.latashinsky.HibernateSessionFactory;
import by.latashinsky.entities.Transaction;
import by.latashinsky.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TransactionRepository {
    private static TransactionRepository transactionRepository;

    private TransactionRepository() {
    }

    public static TransactionRepository getInstance() {
        if (transactionRepository == null) {
            transactionRepository = new TransactionRepository();
        }
        return transactionRepository;
    }

    SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();

    public List<Transaction> findAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Transaction> users = session.createQuery("FROM Transaction ").list();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    public void save(Transaction transaction) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        if (transaction.getId() != 0) {
            session.update(transaction);
        } else {
            session.save(transaction);
        }
        session.getTransaction().commit();
        session.close();
    }
}
