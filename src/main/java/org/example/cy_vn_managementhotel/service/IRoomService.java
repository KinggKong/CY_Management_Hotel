package org.example.cy_vn_managementhotel.service;

import org.example.cy_vn_managementhotel.dto.RoomRequest;
import org.example.cy_vn_managementhotel.entity.Room;
import org.example.cy_vn_managementhotel.model.RoomResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IRoomService {
    List<RoomResponse> getAllRooms();

    List<RoomResponse> pagination(int pageNumber, int pageSize);

    Long countAllRooms();

    List<RoomResponse> paginationRoomAvailable(int pageNumber, int pageSize, LocalDateTime checkin, LocalDateTime checkout);

    int addRoom(RoomRequest roomRequest);

    int updateRoom(RoomRequest roomRequest, Long id);

    int deleteRoom(Long id);

    RoomResponse findById(Long id);

    List<RoomResponse> searchByLocationAndDate(Long idLocation, LocalDate date, int pageSize, int pageNumber);

    Long countAllSearch(Long idLocation, LocalDate date);

}
