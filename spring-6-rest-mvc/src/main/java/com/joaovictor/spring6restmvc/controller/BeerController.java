package com.joaovictor.spring6restmvc.controller;

import com.joaovictor.spring6restmvc.model.Beer;
import com.joaovictor.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Slf4j
@AllArgsConstructor
@Controller
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerById(UUID id) {

        log.debug("Get beer by id from BeerController.java");

        return beerService.getBeerById(id);
    }
}
