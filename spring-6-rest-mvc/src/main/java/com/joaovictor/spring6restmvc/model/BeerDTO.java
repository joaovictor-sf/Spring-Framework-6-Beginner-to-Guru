package com.joaovictor.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class BeerDTO {
    private UUID id;// UUID is a class that generates a random ID
    private Integer version;
    private String beerName;
    private BeerStyle beerStyle;
    private String upc;
    private Integer quantityOnHand;
    private BigDecimal price;// BigDecimal is a class that handles money
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
