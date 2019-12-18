package com.hotels.demohotels.services;

import com.hotels.demohotels.dto.HotelDto;
import com.hotels.demohotels.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {

    private HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDto> getHotelByCityId(Integer cityId) {
        return hotelRepository.findByCityId(cityId).stream().map(hotel -> HotelDto.builder()
                .id(hotel.getId())
                .city_id(hotel.getCityId())
                .name(hotel.getName())
                .status(hotel.getStatus())
                .build()).collect(Collectors.toList());
    }
}
