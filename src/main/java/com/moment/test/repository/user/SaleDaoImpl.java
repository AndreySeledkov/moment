package com.moment.test.repository.user;

import com.moment.test.entities.Sale;
import com.moment.test.repository.AbstractDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public class SaleDaoImpl extends AbstractDao<Integer, Sale> implements SaleDao {

    @Override
    public Optional<Sale> findById(int id) {
        Session session = getSessionFactory().getCurrentSession();
        return Optional.of(session.get(Sale.class, id));
    }

    @Override
    public boolean deleteById(int id) {
        Session session = getSessionFactory().getCurrentSession();
        Sale sale = session.load(Sale.class, id);
        session.delete(sale);

        return true;
    }

    @Override
    public Sale save(Sale sale) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(sale);
        return sale;
    }

    @Override
    public List<Sale> findByDiscount(int discount) {
        Session session = getSessionFactory().getCurrentSession();
        return session.createQuery("from Sale where discount = :discount")
                .setParameter("discount", discount)
                .getResultList();
    }

    @Override
    public List<Sale> getSalesProduct(LocalDate start, LocalDate end) {
        Session session = getSessionFactory().getCurrentSession();
        return session.createQuery("from Sale as s where s.date between :stDate and :edDate ")
                .setParameter("stDate", start)
                .setParameter("edDate", end)
                .list();
    }
}
