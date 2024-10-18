package org.example.cy_vn_managementhotel.mapper;

import org.example.cy_vn_managementhotel.entity.Address;
import org.example.cy_vn_managementhotel.model.AddressResponse;

import java.util.ArrayList;
import java.util.List;

public class AddressMapper {
    public static List<AddressResponse> toListAddressResponse(List<Address> addressList) {
        List<AddressResponse> addressResponseList = new ArrayList<>();
        for (Address address : addressList) {
            AddressResponse addressResponse = toAddressResponse(address);
            addressResponseList.add(addressResponse);
        }
        return addressResponseList;
    }

    public static AddressResponse toAddressResponse(Address address) {
        return AddressResponse.builder()
                .id(address.getId())
                .name(address.getName())
                .idCommune(address.getIdCommune())
                .idDistrict(address.getIdDistrict())
                .idProvince(address.getIdProvince())
                .build();
    }
}
