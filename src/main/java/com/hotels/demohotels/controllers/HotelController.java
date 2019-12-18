package com.hotels.demohotels.controllers;

import com.hotels.demohotels.dto.HotelDto;
import com.hotels.demohotels.services.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/api/v1/hotel/search")
    public ResponseEntity getHotel(@RequestParam Integer city_id) {

        List<HotelDto> hotels = hotelService.getHotelByCityId(city_id);
        if(hotels == null || hotels.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
}
