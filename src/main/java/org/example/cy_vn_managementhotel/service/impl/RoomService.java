package org.example.cy_vn_managementhotel.service.impl;

import org.example.cy_vn_managementhotel.dto.RoomRequest;
import org.example.cy_vn_managementhotel.entity.Room;
import org.example.cy_vn_managementhotel.mapper.RoomMapper;
import org.example.cy_vn_managementhotel.model.RoomResponse;
import org.example.cy_vn_managementhotel.repository.RoomRepository;
import org.example.cy_vn_managementhotel.service.IRoomService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class RoomService implements IRoomService {
    RoomRepository roomRepository = new RoomRepository();

    @Override
    public List<RoomResponse> getAllRooms() {
        List<Room> rooms = roomRepository.getAllRooms();
        return RoomMapper.toListRoomResponse(rooms);
    }

    @Override
    public List<RoomResponse> pagination(int pageNumber, int pageSize) {
        List<Room> rooms = roomRepository.pagination(pageNumber, pageSize);
        return RoomMapper.toListRoomResponse(rooms);
    }

    @Override
    public Long countAllRooms() {
        return roomRepository.countAllRoom();
    }

    @Override
    public List<RoomResponse> paginationRoomAvailable(int pageNumber, int pageSize, LocalDateTime checkin, LocalDateTime checkout) {
        List<Room> rooms = roomRepository.paginationAvailableRoom(pageNumber, pageSize, checkin, checkout);
        return RoomMapper.toListRoomResponse(rooms);
    }

    @Override
    public int addRoom(RoomRequest roomRequest) {
        Room room = RoomMapper.toRoom(roomRequest);
        return roomRepository.insertRoom(room);
    }

    @Override
    public int updateRoom(RoomRequest roomRequest, Long id) {
        return 0;
    }

    @Override
    public int deleteRoom(Long id) {
        return 0;
    }

    @Override
    public RoomResponse findById(Long id) {
        Room room = roomRepository.findById(id);
        return RoomMapper.toRoomResponse(room);
    }

    @Override
    public List<RoomResponse> searchByLocationAndDate(Long idLocation, LocalDate date, int pageSize, int pageNumber) {
        List<Room> roomList = roomRepository.searchByLocationWithDate(idLocation, date, pageSize, pageNumber);
        return RoomMapper.toListRoomResponse(roomList);
    }

    @Override
    public Long countAllSearch(Long idLocation, LocalDate date) {
        return roomRepository.countAllSearch(idLocation, date);
    }

}
