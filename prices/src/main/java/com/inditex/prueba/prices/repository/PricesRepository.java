package com.inditex.prueba.prices.repository;

import com.inditex.prueba.prices.model.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PricesRepository extends JpaRepository<Price, Integer> {

    Price findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc
            (LocalDateTime dateFrom, LocalDateTime dateTo, Integer productId, Integer brandId);

}
