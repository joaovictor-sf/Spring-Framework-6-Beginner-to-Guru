package com.joaovictor.spring6restmvc.services;

import com.joaovictor.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    Beer getBeerById(UUID Id);

    List<Beer> listBeers();

    Beer saveNewBeer(Beer beer);

    void updateBeer(UUID id, Beer beer);
}
