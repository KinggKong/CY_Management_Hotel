package org.example.cy_vn_managementhotel.repository;

import org.example.cy_vn_managementhotel.entity.Hotel;
import org.example.cy_vn_managementhotel.entity.Room;
import org.example.cy_vn_managementhotel.entity.TypeRoom;
import org.example.cy_vn_managementhotel.utils.DBHepler;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {
    HotelRepository hotelRepository = new HotelRepository();
    TypeRoomRepository typeRoomRepository = new TypeRoomRepository();

    public List<Room> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "select * from room";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Room newRoom = buildFromResultSet(resultSet);
                    rooms.add(newRoom);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rooms;
    }

    public List<Room> pagination(int pageNumber, int pageSize) {
        List<Room> rooms = new ArrayList<>();
        int offset = pageSize * pageNumber;
        String sql = "select * from room limit ? offset ? ";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, pageSize);
            preparedStatement.setInt(2, offset);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Room newRoom = buildFromResultSet(resultSet);
                    rooms.add(newRoom);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rooms;
    }

    public List<Room> paginationAvailableRoom(int pageNumber, int pageSize, LocalDateTime checkin, LocalDateTime checkout) {
        List<Room> rooms = new ArrayList<>();
        int offset = pageSize * pageNumber;
        String sql = "select r.* from room r\n" +
                "left join bill_detail bdt on bdt.id_room = r.id  where (bdt.checkout < ? or bdt.checkout is null) \n" +
                "or (bdt.checkin > ? or bdt.checkin is null) limit ? offset ?";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setTimestamp(1, Timestamp.valueOf(checkin));
            preparedStatement.setTimestamp(2, Timestamp.valueOf(checkout));
            preparedStatement.setInt(3, pageSize);
            preparedStatement.setInt(4, offset);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Room newRoom = buildFromResultSet(resultSet);
                    rooms.add(newRoom);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rooms;
    }

    public Long countAllRoom() {
        Long count = 0L;
        String sql = "select count(*) as soLuong from room";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    count = resultSet.getLong("soLuong");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public int insertRoom(Room room) {
        int result = 0;
        String sql = "INSERT INTO `room` (`name`, `price`, `description`, `id_type_room`, `number_of_bed`, `rate`, `image`, `number_of_person`, `id_hotel`, `status`) VALUES\n" +
                "(?,?,?,?,?,?,?,?,?,?)";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, room.getName());
            preparedStatement.setDouble(2, room.getPrice());
            preparedStatement.setString(3, room.getDescription());
            preparedStatement.setLong(4, room.getTypeRoom().getId());
            preparedStatement.setInt(5, room.getNumberOfBed());
            preparedStatement.setDouble(6, room.getRate());
            preparedStatement.setString(7, room.getImage());
            preparedStatement.setInt(8, room.getNumberOfPerson());
            preparedStatement.setLong(9, room.getHotel().getId());
            preparedStatement.setString(10, room.getStatus());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public Room findById(Long id) {
        Room room = null;
        String sql = "select * from room where id = ?";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    room = buildFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return room;
    }

    public List<Room> searchByLocationWithDate(Long idProvince, LocalDate dateSearch, int pageSize, int pageNumber) {
        List<Room> rooms = new ArrayList<>();
        int offset = pageSize * pageNumber;
        String sql = "SELECT r.*\n" +
                "FROM room r\n" +
                "inner join hotel ht on ht.id = r.id_hotel\n" +
                "inner join address ad on ad.id = ht.id_address\n" +
                "LEFT JOIN bill_detail bd ON bd.id_room = r.id\n" +
                "WHERE (bd.checkout < ? OR bd.id_room IS NULL) and (ad.id_province = ? )  limit ? offset ?;\n";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, dateSearch.toString());
            preparedStatement.setLong(2, idProvince);
            preparedStatement.setInt(3, pageSize);
            preparedStatement.setInt(4, offset);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Room newRoom = buildFromResultSet(resultSet);
                    rooms.add(newRoom);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rooms;
    }

    public Long countAllSearch(Long idProvince, LocalDate dateSearch) {
        Long count = 0L;
        String sql = "SELECT count(*) as soLuong\n" +
                "FROM room r\n" +
                "inner join hotel ht on ht.id = r.id_hotel\n" +
                "inner join address ad on ad.id = ht.id_address\n" +
                "LEFT JOIN bill_detail bd ON bd.id_room = r.id\n" +
                "WHERE (bd.checkout < ? OR bd.id_room IS NULL) and (ad.id_province = ? );";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, dateSearch.toString());
            preparedStatement.setLong(2, idProvince);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    count = resultSet.getLong("soLuong");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    private Room buildFromResultSet(ResultSet resultSet) throws SQLException {
        LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();
        LocalDateTime updatedAt = resultSet.getTimestamp("updated_at").toLocalDateTime();
        Long idTypeRoom = resultSet.getLong("id_type_room");
        Long idHotel = resultSet.getLong("id_hotel");
        Hotel hotel = hotelRepository.findById(idHotel);
        TypeRoom typeRoom = typeRoomRepository.findById(idTypeRoom);
        Room room = Room.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .price(resultSet.getDouble("price"))
                .rate(resultSet.getFloat("rate"))
                .image(resultSet.getString("image"))
                .description(resultSet.getString("description"))
                .numberOfPerson(resultSet.getInt("number_of_person"))
                .numberOfBed(resultSet.getInt("number_of_bed"))
                .status(resultSet.getString("status"))
                .hotel(hotel)
                .typeRoom(typeRoom)
                .build();
        room.setCreatedAt(createdAt);
        room.setUpdatedAt(updatedAt);
        return room;
    }

}
