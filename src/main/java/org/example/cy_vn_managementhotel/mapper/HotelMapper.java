package org.example.cy_vn_managementhotel.mapper;

import org.example.cy_vn_managementhotel.entity.Hotel;
import org.example.cy_vn_managementhotel.model.HotelResponse;

public class HotelMapper {
    public static Hotel toHotel(HotelResponse hotelResponse) {
        return Hotel.builder()
                .id(hotelResponse.getId())
                .name(hotelResponse.getName())
                .address(hotelResponse.getAddress())
                .specificAddress(hotelResponse.getSpecificAddress())
                .status(hotelResponse.getStatus())
                .build();
    }

    public static  HotelResponse toHotelResponse(Hotel hotel) {
        return HotelResponse.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .address(hotel.getAddress())
                .specificAddress(hotel.getSpecificAddress())
                .status(hotel.getStatus())
                .build();
    }
}
