package com.inditex.prueba.prices.utils;

import com.inditex.prueba.prices.model.PriceResponse;
import com.inditex.prueba.prices.model.entity.Price;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.stereotype.Component;

@Component
public class ObjectEntityMapper {
    private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    private MapperFacade mapper = mapperFactory.getMapperFacade();

    public PriceResponse toResponse(Price price){

        return mapper.map(price, PriceResponse.class);
    }
    public Price toEntity(PriceResponse priceResponse){

        return mapper.map(priceResponse, Price.class);
    }

}
