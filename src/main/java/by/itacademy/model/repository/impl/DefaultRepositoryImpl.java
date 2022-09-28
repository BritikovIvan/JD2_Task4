package by.itacademy.model.repository.impl;

import by.itacademy.model.DataSource;
import by.itacademy.model.repository.DefaultRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public abstract class DefaultRepositoryImpl<T> implements DefaultRepository<T> {

    private final Class<T> tClass;

    public DefaultRepositoryImpl(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public void save(T entity) {
        Session session = DataSource.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
    }

    @Override
    public Optional<T> findById(Long id) {
        Session session = DataSource.getInstance().getSession();
        return Optional.ofNullable(session.find(tClass, id));
    }

    @Override
    public List<T> findAll() {
        Session session = DataSource.getInstance().getSession();
        return session.createQuery("from " + tClass.getName(), tClass).getResultList();
    }

    @Override
    public void delete(Long id) {
        Session session = DataSource.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        T entity = session.find(tClass, id);
        session.remove(entity);
        transaction.commit();
    }

    @Override
    public void update(T entity) {
        Session session = DataSource.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        transaction.commit();
    }
}
