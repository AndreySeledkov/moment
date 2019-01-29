package com.moment.test.service.product;

import com.moment.test.entities.Product;
import com.moment.test.repository.user.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Seledkov Andrii on 18.01.2019.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public Optional<Product> findById(int id) {
        return productDao.findById(id);
    }

    @Override
    public boolean deleteById(int id) {
        return productDao.deleteById(id);
    }
}
