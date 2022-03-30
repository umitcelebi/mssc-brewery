package com.umitclebi.msscbrewery.services.v2;

import com.umitclebi.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerServiceV2 {
    BeerDto getBeerById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
