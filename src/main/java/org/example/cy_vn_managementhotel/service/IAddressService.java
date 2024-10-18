package org.example.cy_vn_managementhotel.service;

import org.example.cy_vn_managementhotel.model.AddressResponse;

import java.util.List;

public interface IAddressService {
    List<AddressResponse> findAllProvince();
}
