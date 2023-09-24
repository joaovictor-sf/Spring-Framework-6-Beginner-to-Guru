package com.joaovictor.spring6restmvc.services;

import com.joaovictor.spring6restmvc.model.Beer;
import com.joaovictor.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public Beer getBeerById(UUID id) {

        log.debug("I was called from BeerServiceImpl.java");

        return Beer.builder()
                .id(id)
                .version(1)
                .beerName("Heineken")
                .beerStyle(BeerStyle.ALE)
                .upc("123456789")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(100)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();
    }
}
