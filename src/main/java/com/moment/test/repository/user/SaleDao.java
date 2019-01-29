package com.moment.test.repository.user;


import com.moment.test.entities.Sale;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SaleDao {

    Optional<Sale> findById(int id);
    boolean deleteById(int id);
    Sale save(Sale sale);
    List<Sale> findByDiscount(int discount);
    List<Sale> getSalesProduct(LocalDate start, LocalDate end);
}

