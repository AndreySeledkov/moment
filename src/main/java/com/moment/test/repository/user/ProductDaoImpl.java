package com.moment.test.repository.user;

import com.moment.test.entities.Product;
import com.moment.test.repository.AbstractDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
@Transactional
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

    @Override
    public Optional<Product> findById(int id) {
        Session session = getSessionFactory().getCurrentSession();
        return Optional.of(session.get(Product.class, id));
    }

    @Override
    public boolean deleteById(int id) {
        Session session = getSessionFactory().getCurrentSession();
        Product product = session.load(Product.class, id);
        session.delete(product);

        return true;
    }

    @Override
    public Product save(Product product) {
        Session session = getSessionFactory().getCurrentSession();
        session.saveOrUpdate(product);
        return product;
    }
}
