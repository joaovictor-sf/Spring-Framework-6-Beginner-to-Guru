package com.joaovictor.spring6restmvc.services;

import com.joaovictor.spring6restmvc.model.BeerDTO;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    BeerDTO getBeerById(UUID Id);

    List<BeerDTO> listBeers();

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    void updateBeer(UUID id, BeerDTO beerDTO);

    void deleteById(UUID id);

    void upatchBeerById(UUID id, BeerDTO beerDTO);
}
