package org.example.cy_vn_managementhotel.mapper;

import org.example.cy_vn_managementhotel.entity.TypeRoom;
import org.example.cy_vn_managementhotel.model.TypeRoomResponse;

public class TypeRoomMapper {
    public static TypeRoom toTypeRoom(TypeRoomResponse typeRoomResponse) {
        return TypeRoom.builder()
                .id(typeRoomResponse.getId())
                .name(typeRoomResponse.getName())
                .facility(typeRoomResponse.getFacility())
                .build();
    }
    public static TypeRoomResponse toTypeRoomResponse(TypeRoom typeRoom) {
        return TypeRoomResponse.builder()
                .id(typeRoom.getId())
                .name(typeRoom.getName())
                .facility(typeRoom.getFacility())
                .build();
    }
}
