package com.inditex.prueba.prices;


import com.inditex.prueba.prices.controller.PricesController;
import com.inditex.prueba.prices.model.PriceResponse;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PriceControllerTest {

    @Autowired
    private PricesController pricesController;

    @Test
    void whenGetData_thenReturnPriceTest() throws ParseException {

        LocalDateTime date1 = LocalDateTime.of(2020, Month.JUNE, 14, 10, 00, 00);

        final ResponseEntity<PriceResponse> prices1 = pricesController.getPriceFilter(date1, 35455, 1);

        Assert.assertNotNull(prices1);
        Assert.assertEquals(HttpStatus.OK, prices1.getStatusCode());
    }

    @Test
    void whenGetDate_thenNullDateParameter(){

        try{
            pricesController.getPriceFilter(null, 35455, 1);
        } catch (InvalidDataAccessApiUsageException e) {
            assertThat(e.getMessage().contains("Value must not be null!"));
        }
    }
    @Test
    void whenGetDate_thenMissignProductIdParameter() throws ParseException {

        LocalDateTime dateTest2 = LocalDateTime.of(2020, Month.JUNE, 16, 10, 00, 00);

        final ResponseEntity<PriceResponse> priceFilter =
                pricesController.getPriceFilter(dateTest2, null, 1);

        Assert.assertEquals(HttpStatus.NO_CONTENT, priceFilter.getStatusCode());

    }
    @Test
    void whenGetDate_thenMissignBrandIdParameter() throws ParseException {

        LocalDateTime dateTest2 = LocalDateTime.of(2020, Month.JUNE, 16, 10, 00, 00);

        final ResponseEntity<PriceResponse> priceFilter =
                pricesController.getPriceFilter(dateTest2, 35455, null);

        Assert.assertEquals(HttpStatus.NO_CONTENT, priceFilter.getStatusCode());

    }
}
