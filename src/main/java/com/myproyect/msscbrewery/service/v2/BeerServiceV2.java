package com.myproyect.msscbrewery.service.v2;

import com.myproyect.msscbrewery.web.model.BeerDto;
import com.myproyect.msscbrewery.web.model.v2.BeerDtoV2;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

    void updateNewBeer(UUID beerId, BeerDtoV2 beerDto);

    void deleteById(UUID beerId);
}
