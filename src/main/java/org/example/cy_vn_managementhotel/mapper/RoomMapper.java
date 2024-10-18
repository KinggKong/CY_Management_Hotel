package org.example.cy_vn_managementhotel.mapper;

import org.example.cy_vn_managementhotel.dto.RoomRequest;
import org.example.cy_vn_managementhotel.entity.Room;
import org.example.cy_vn_managementhotel.model.RoomResponse;

import java.util.ArrayList;
import java.util.List;

public class RoomMapper {

    public static List<RoomResponse> toListRoomResponse(List<Room> rooms) {
        List<RoomResponse> roomResponses = new ArrayList<>();
        for (Room room : rooms) {
            RoomResponse roomResponse = toRoomResponse(room);
            roomResponses.add(roomResponse);
        }
        return roomResponses;
    }

    public static RoomResponse toRoomResponse(Room room) {
        return RoomResponse.builder()
                .id(room.getId())
                .name(room.getName())
                .hotel(room.getHotel())
                .rate(room.getRate())
                .typeRoom(room.getTypeRoom())
                .price(room.getPrice())
                .description(room.getDescription())
                .image(room.getImage())
                .status(room.getStatus())
                .numberOfBed(room.getNumberOfBed())
                .numberOfPerson(room.getNumberOfPerson())
                .createdAt(room.getCreatedAt())
                .updatedAt(room.getUpdatedAt())
                .build();
    }

    public static Room toRoom(RoomRequest roomRequest) {
        return Room.builder()
                .name(roomRequest.getName())
                .price(roomRequest.getPrice())
                .description(roomRequest.getDescription())
                .image(roomRequest.getImage())
                .numberOfBed(roomRequest.getNumberOfBed())
                .numberOfPerson(roomRequest.getNumberOfPerson())
                .status(roomRequest.getStatus())
                .rate(roomRequest.getRate())
                .typeRoom(roomRequest.getTypeRoom())
                .hotel(roomRequest.getHotel())
                .build();
    }

    public static Room toRoom(RoomResponse roomResponse) {
        return Room.builder()
                .id(roomResponse.getId())
                .name(roomResponse.getName())
                .price(roomResponse.getPrice())
                .description(roomResponse.getDescription())
                .image(roomResponse.getImage())
                .numberOfBed(roomResponse.getNumberOfBed())
                .numberOfPerson(roomResponse.getNumberOfPerson())
                .rate(roomResponse.getRate())
                .typeRoom(roomResponse.getTypeRoom())
                .hotel(roomResponse.getHotel())
                .status(roomResponse.getStatus())
                .build();
    }
}
