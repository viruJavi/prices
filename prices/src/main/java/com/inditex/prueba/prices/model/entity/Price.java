package com.inditex.prueba.prices.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "prices")
public class Price {

    @Id
    @Column(name = "id")
    private Integer idPrice;

    @Column(name = "brand_id", nullable = false)
    private Integer brandId;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "price_list")
    private Integer priceList;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "price")
    private Double price;

    @Column(name = "curr")
    private String curr;


}
