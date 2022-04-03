package com.umitclebi.msscbrewery.web.mappers;

import com.umitclebi.msscbrewery.domain.Beer;
import com.umitclebi.msscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
