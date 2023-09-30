package com.joaovictor.spring6restmvc.services;

import com.joaovictor.spring6restmvc.model.BeerDTO;
import com.joaovictor.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, BeerDTO> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        BeerDTO beerDTO1 = BeerDTO.builder()
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

        BeerDTO beerDTO2 = BeerDTO.builder()
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

        BeerDTO beerDTO3 = BeerDTO.builder()
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

        beerMap.put(beerDTO1.getId(), beerDTO1);
        beerMap.put(beerDTO2.getId(), beerDTO2);
        beerMap.put(beerDTO3.getId(), beerDTO3);
    }

    @Override
    public List<BeerDTO> listBeers() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {

        BeerDTO saveBeerDTO = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName(beerDTO.getBeerName())
                .beerStyle(beerDTO.getBeerStyle())
                .upc(beerDTO.getUpc())
                .price(beerDTO.getPrice())
                .quantityOnHand(beerDTO.getQuantityOnHand())
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        beerMap.put(saveBeerDTO.getId(), saveBeerDTO);

        return saveBeerDTO;
    }

    @Override
    public void updateBeer(UUID id, BeerDTO beerDTO) {

            BeerDTO existingBeerDTO = beerMap.get(id);

            existingBeerDTO.setBeerName(beerDTO.getBeerName());
            existingBeerDTO.setBeerStyle(beerDTO.getBeerStyle());
            existingBeerDTO.setPrice(beerDTO.getPrice());
            existingBeerDTO.setQuantityOnHand(beerDTO.getQuantityOnHand());
            existingBeerDTO.setUpc(beerDTO.getUpc());

            existingBeerDTO.setUpdatedDate(LocalDateTime.now());

            beerMap.put(existingBeerDTO.getId(), existingBeerDTO);
    }

    @Override
    public void deleteById(UUID id) {
        beerMap.remove(id);
    }

    @Override
    public void upatchBeerById(UUID id, BeerDTO beerDTO) {
        BeerDTO existingBeerDTO = beerMap.get(id);

        if (StringUtils.hasText(beerDTO.getBeerName())) {
            existingBeerDTO.setBeerName(beerDTO.getBeerName());
        }

        if (beerDTO.getBeerStyle() != null) {
            existingBeerDTO.setBeerStyle(beerDTO.getBeerStyle());
        }

        if (beerDTO.getPrice() != null) {
            existingBeerDTO.setPrice(beerDTO.getPrice());
        }

        if (beerDTO.getQuantityOnHand() != null) {
            existingBeerDTO.setQuantityOnHand(beerDTO.getQuantityOnHand());
        }

        if (StringUtils.hasText(beerDTO.getUpc())) {
            existingBeerDTO.setUpc(beerDTO.getUpc());
        }

        existingBeerDTO.setUpdatedDate(LocalDateTime.now());
    }

    @Override
    public BeerDTO getBeerById(UUID id) {

        log.debug("I was called from BeerServiceImpl.java");

        return beerMap.get(id);
    }
}
