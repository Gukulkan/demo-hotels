package com.hotels.demohotels.repository;

import com.hotels.demohotels.entity.Hotel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HotelRepository  extends CrudRepository<Hotel, Integer> {
    List<Hotel> findByCityId(Integer cityId);
}
