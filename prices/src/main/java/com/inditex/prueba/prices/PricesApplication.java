package com.inditex.prueba.prices;

import com.inditex.prueba.prices.model.PriceResponse;
import com.inditex.prueba.prices.model.entity.Price;
import com.inditex.prueba.prices.repository.PricesRepository;
import com.inditex.prueba.prices.service.PricesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@EnableAutoConfiguration
public class PricesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PricesApplication.class, args);
	}

}
