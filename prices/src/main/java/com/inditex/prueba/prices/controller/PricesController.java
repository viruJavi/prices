package com.inditex.prueba.prices.controller;


import com.inditex.prueba.prices.model.PriceResponse;
import com.inditex.prueba.prices.service.PricesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/prices")
@Api(value = "API services", produces = "application/json")
public class PricesController {

    private final PricesService pricesService;

    @Autowired
    public PricesController(PricesService pricesService){
        this.pricesService = pricesService;
    }

    @GetMapping("/{date}/{productId}/{brandId}")
    @ApiOperation(value = "Filter prices by date, producIt and brandId", notes = "get Price Filtered")
    public ResponseEntity<PriceResponse> getPriceFilter(@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                                        @PathVariable(value = "date") LocalDateTime date,
                                                       @PathVariable(value = "productId") Integer productId,
                                                       @PathVariable(value = "brandId") Integer brandId){

        final PriceResponse productByBrand = pricesService
                .getPriceByDateByProductByBrand(date, productId, brandId);

        return Optional.ofNullable(productByBrand).map(p -> ResponseEntity.ok().body(productByBrand))
                .orElseGet(() ->ResponseEntity.noContent().build());

    }
}
