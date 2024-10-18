package org.example.cy_vn_managementhotel.service.impl;

import org.example.cy_vn_managementhotel.entity.Address;
import org.example.cy_vn_managementhotel.mapper.AddressMapper;
import org.example.cy_vn_managementhotel.model.AddressResponse;
import org.example.cy_vn_managementhotel.repository.AddressRepository;
import org.example.cy_vn_managementhotel.service.IAddressService;

import java.util.List;

public class AddressService implements IAddressService {
    AddressRepository addressRepository = new AddressRepository();

    @Override
    public List<AddressResponse> findAllProvince() {
        List<Address> addressList = addressRepository.findAllProvince();
        return AddressMapper.toListAddressResponse(addressList);
    }
}
