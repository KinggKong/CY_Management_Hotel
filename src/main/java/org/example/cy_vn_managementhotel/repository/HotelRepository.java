package org.example.cy_vn_managementhotel.repository;

import org.example.cy_vn_managementhotel.entity.Address;
import org.example.cy_vn_managementhotel.entity.Hotel;
import org.example.cy_vn_managementhotel.utils.DBHepler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelRepository {
    public Hotel findById(Long id) {
        Hotel hotel = null;
        String sql = "select h.*, ad.name_address,ad.id_province, ad.id_district, ad.id_commune from hotel h \n" +
                "inner join address ad on h.id_address = ad.id where h.id = ?";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    hotel = buildFromResultSet(resultSet);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hotel;
    }

    public List<Hotel> getAll(Long id) {
        List<Hotel> list = new ArrayList<>();
        String sql = "select h.*, ad.name_address,ad.id_province, ad.id_district, ad.id_commune from hotel h \n" +
                "inner join address ad on h.id_address = ad.id";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            try (ResultSet resultSet = preparedStatement.executeQuery();) {
                while (resultSet.next()) {
                    Hotel hotel = buildFromResultSet(resultSet);
                    list.add(hotel);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int insert(Hotel hotel) {
        int result = 0;
        String sql = "INSERT INTO hotel (`name`, `specific_address`, `status`, `id_address`) VALUES (?,?,?,?)";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, hotel.getName());
            preparedStatement.setString(2, hotel.getSpecificAddress());
            preparedStatement.setInt(3, hotel.getStatus());
            preparedStatement.setLong(4, hotel.getAddress().getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int update(Hotel hotel, Long id) {
        int result = 0;
        String sql = "update hotel set name = ?, specific_address = ?, status = ?, id_address = ? where id = ?";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, hotel.getName());
            preparedStatement.setString(2, hotel.getSpecificAddress());
            preparedStatement.setInt(3, hotel.getStatus());
            preparedStatement.setLong(4, hotel.getAddress().getId());
            preparedStatement.setLong(5, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private Hotel buildFromResultSet(ResultSet resultSet) throws SQLException {
        Address address = Address.builder()
                .name(resultSet.getString("name_address"))
                .id(resultSet.getLong("id_address"))
                .idProvince(resultSet.getLong(("id_province")))
                .idDistrict(resultSet.getLong(("id_district")))
                .idCommune(resultSet.getLong(("id_commune")))
                .build();
        return Hotel.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .status(resultSet.getInt("status"))
                .specificAddress(resultSet.getString("specific_address"))
                .address(address)
                .build();
    }
}
