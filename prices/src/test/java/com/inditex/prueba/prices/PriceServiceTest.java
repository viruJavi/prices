package com.inditex.prueba.prices;


import com.inditex.prueba.prices.model.PriceResponse;
import com.inditex.prueba.prices.service.PricesService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.Month;

@SpringBootTest
class PriceServiceTest {

    @Autowired
    private PricesService pricesService;

    LocalDateTime dateStart = LocalDateTime.of(2020, Month.JUNE, 14, 10, 00, 00);
    LocalDateTime dateEnd = LocalDateTime.of(2020, Month.DECEMBER, 31, 23, 59, 59);

    private final static Double PRICE1 = 35.50;
    private final static Double PRICE2 = 25.45;
    private final static Double PRICE4 = 30.50;
    private final static Double PRICE5 = 38.94;



    private PriceResponse priceDto = PriceResponse.builder().idPrice(0).brandId(1).priceList(1).productId(35455)
                        .curr("EUR").startDate(dateStart).endDate(dateEnd).build();

    @Test
    void whenGetDate_thenReturnPriceTest1(){

        LocalDateTime date1 = LocalDateTime.of(2020, Month.JUNE, 14, 10, 00, 00);

        final PriceResponse prices1 = pricesService.getPriceByDateByProductByBrand(date1, 35455, 1);

        Assert.assertNotNull(prices1);
        Assert.assertEquals(priceDto.getIdPrice(), prices1.getIdPrice());
        Assert.assertEquals(PRICE1, prices1.getPrice());

    }
    @Test
    void whenGetDate_thenReturnPriceTest2(){

        LocalDateTime date2 = LocalDateTime.of(2020, Month.JUNE, 14, 16, 00, 00);

        final PriceResponse prices = pricesService.getPriceByDateByProductByBrand(date2, 35455, 1);

        Assert.assertNotNull(prices);
        Assert.assertEquals(Integer.valueOf(1), prices.getIdPrice());
        Assert.assertEquals(PRICE2, prices.getPrice());
    }
    @Test
    void whenGetDate_thenReturnPriceTest3(){

        LocalDateTime date3 = LocalDateTime.of(2020, Month.JUNE, 14, 21, 00, 00);

        final PriceResponse prices = pricesService.getPriceByDateByProductByBrand(date3, 35455, 1);

        Assert.assertNotNull(prices);
        Assert.assertEquals(Integer.valueOf(0), prices.getIdPrice());

    }
    @Test
    void whenGetDate_thenReturnPriceTest4() throws ParseException {

        LocalDateTime date4 = LocalDateTime.of(2020, Month.JUNE, 15, 10, 00, 00);

        final PriceResponse prices = pricesService.getPriceByDateByProductByBrand(date4, 35455, 1);

        Assert.assertNotNull(prices);
        Assert.assertEquals(Integer.valueOf(2), prices.getIdPrice());
        Assert.assertEquals(PRICE4, prices.getPrice());

    }
    @Test
    void whenGetDate_thenReturnPriceTest5(){

        LocalDateTime date5 = LocalDateTime.of(2020, Month.JUNE, 16, 21, 00, 00);

        final PriceResponse prices = pricesService.getPriceByDateByProductByBrand(date5, 35455, 1);

        Assert.assertNotNull(prices);
        Assert.assertEquals(Integer.valueOf(3), prices.getIdPrice());
        Assert.assertEquals(PRICE5, prices.getPrice());

    }
    @Test
    void whenGetDate_thenNotFindPrice(){

        LocalDateTime date = LocalDateTime.of(2019, Month.JUNE, 14, 16, 00, 00);

        final PriceResponse prices = pricesService.getPriceByDateByProductByBrand(date, 35455, 1);

        Assert.assertNull(prices);
    }
}
