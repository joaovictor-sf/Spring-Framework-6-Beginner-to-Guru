package com.joaovictor.spring6restmvc.services;

import com.joaovictor.spring6restmvc.model.Beer;
import com.joaovictor.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Heineken")
                .beerStyle(BeerStyle.ALE)
                .upc("123456789")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(100)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Skol")
                .beerStyle(BeerStyle.ALE)
                .upc("987654321")
                .price(new BigDecimal("10.99"))
                .quantityOnHand(100)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Brahma")
                .beerStyle(BeerStyle.ALE)
                .upc("123456789")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(100)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public List<Beer> listBeers() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer saveNewBeer(Beer beer) {

        Beer saveBeer = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .quantityOnHand(beer.getQuantityOnHand())
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        beerMap.put(saveBeer.getId(), saveBeer);

        return saveBeer;
    }

    @Override
    public void updateBeer(UUID id, Beer beer) {

            Beer existingBeer = beerMap.get(id);

            existingBeer.setBeerName(beer.getBeerName());
            existingBeer.setBeerStyle(beer.getBeerStyle());
            existingBeer.setPrice(beer.getPrice());
            existingBeer.setQuantityOnHand(beer.getQuantityOnHand());
            existingBeer.setUpc(beer.getUpc());

            beerMap.put(existingBeer.getId(), existingBeer);
    }

    @Override
    public Beer getBeerById(UUID id) {

        log.debug("I was called from BeerServiceImpl.java");

        return beerMap.get(id);
    }
}
