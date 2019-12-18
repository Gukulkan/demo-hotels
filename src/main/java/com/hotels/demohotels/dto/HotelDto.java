package com.hotels.demohotels.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelDto {
    private String name;
    private Boolean status;
    private Integer city_id;
}
