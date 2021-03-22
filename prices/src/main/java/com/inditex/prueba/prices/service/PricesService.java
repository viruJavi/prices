package com.inditex.prueba.prices.service;

import com.inditex.prueba.prices.model.PriceResponse;
import com.inditex.prueba.prices.model.entity.Price;
import com.inditex.prueba.prices.repository.PricesRepository;
import com.inditex.prueba.prices.utils.ObjectEntityMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class PricesService {

    private final PricesRepository pricesRepository;
    private final ObjectEntityMapper objectEntityMapper;

    @Autowired
    public PricesService(PricesRepository pricesRepository,
                         ObjectEntityMapper objectEntityMapper){
        this.pricesRepository = pricesRepository;
        this.objectEntityMapper = objectEntityMapper;
    }

    public PriceResponse getPriceByDateByProductByBrand(LocalDateTime date, Integer productId, Integer brandId){

        log.info("Request Date: [{}] Product Id: [{}] Brand Id: [{}]", date, productId, brandId);

        final Price priceEntity =
                pricesRepository.findFirstByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandIdOrderByPriorityDesc
                        (date, date, productId, brandId);
        return Optional.ofNullable(priceEntity).map(p -> {
            PriceResponse priceResponse = objectEntityMapper.toResponse(priceEntity);
            priceResponse.setApplicationDate(date);
            return priceResponse;
        }).orElse(null);
    }
}
