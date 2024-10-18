package org.example.cy_vn_managementhotel.service.impl;

import org.example.cy_vn_managementhotel.entity.TypeRoom;
import org.example.cy_vn_managementhotel.mapper.TypeRoomMapper;
import org.example.cy_vn_managementhotel.model.TypeRoomResponse;
import org.example.cy_vn_managementhotel.repository.TypeRoomRepository;
import org.example.cy_vn_managementhotel.service.ITypeRoomService;

public class TypeRoomService implements ITypeRoomService {
    TypeRoomRepository typeRoomRepository = new TypeRoomRepository();

    @Override
    public TypeRoomResponse findById(Long id) {
        TypeRoom typeRoom = typeRoomRepository.findById(id);
        return TypeRoomMapper.toTypeRoomResponse(typeRoom);
    }
}
