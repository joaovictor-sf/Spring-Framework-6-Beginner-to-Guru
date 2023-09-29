package com.joaovictor.spring6restmvc.controller;

import com.joaovictor.spring6restmvc.model.Beer;
import com.joaovictor.spring6restmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @PatchMapping("{id}")
    public ResponseEntity updateBeerPatchById(@PathVariable("id") UUID id, @RequestBody Beer beer) {
        beerService.upatchBeerById(id, beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable("id") UUID id) {
        beerService.deleteById(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity updateById(@PathVariable("id") UUID id,@RequestBody Beer beer) {
        beerService.updateBeer(id ,beer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Beer beer) {
        Beer savedBeer = beerService.saveNewBeer(beer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + savedBeer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeers() {

        log.debug("List beers from BeerController.java");

        return beerService.listBeers();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Beer getBeerById(@PathVariable("id") UUID id) {

        log.debug("Get beer by id from BeerController.java");

        return beerService.getBeerById(id);
    }
}
