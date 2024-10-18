package org.example.cy_vn_managementhotel.service.impl;

import org.example.cy_vn_managementhotel.mapper.HotelMapper;
import org.example.cy_vn_managementhotel.model.HotelResponse;
import org.example.cy_vn_managementhotel.repository.HotelRepository;
import org.example.cy_vn_managementhotel.service.IHotelService;

public class HotelService implements IHotelService {
    HotelRepository hotelRepository = new HotelRepository();

    @Override
    public HotelResponse findById(Long id) {
        return HotelMapper.toHotelResponse(hotelRepository.findById(id));
    }
}
