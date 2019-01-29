package com.moment.test.service.product;

import com.moment.test.entities.Sale;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by Seledkov Andrii on 18.01.2019.
 */
public interface SaleService {
    Sale save(Sale product);

    Optional<Sale> findById(int id);

    boolean deleteById(int id);

    List<Sale> findByDiscount(int discount);

    double getSummaryAmount(LocalDate start, LocalDate end);
}
