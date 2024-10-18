package org.example.cy_vn_managementhotel.service;

import org.example.cy_vn_managementhotel.entity.Hotel;
import org.example.cy_vn_managementhotel.model.HotelResponse;

public interface IHotelService {
    HotelResponse findById(Long id);
}
