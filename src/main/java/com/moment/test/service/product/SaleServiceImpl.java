package com.moment.test.service.product;

import com.moment.test.entities.Sale;
import com.moment.test.repository.user.SaleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by Seledkov Andrii on 18.01.2019.
 */
@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDao saleDao;

    @Override
    public Sale save(Sale product) {
        return saleDao.save(product);
    }

    @Override
    public Optional<Sale> findById(int id) {
        return saleDao.findById(id);
    }

    @Override
    public boolean deleteById(int id) {
        return saleDao.deleteById(id);
    }


    @Override
    public List<Sale> findByDiscount(int discount) {
        return saleDao.findByDiscount(discount);
    }

    @Override
    public double getSummaryAmount(LocalDate start, LocalDate end) {
        List<Sale> sales = saleDao.getSalesProduct(start, end);
        return sales.stream().mapToDouble(item -> item.getUnitPrice() * item.getQuantity() - item.getTotalPrice()).sum();
    }
}
