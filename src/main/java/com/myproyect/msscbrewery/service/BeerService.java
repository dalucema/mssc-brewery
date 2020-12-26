package com.myproyect.msscbrewery.service;

import com.myproyect.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateNewBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
