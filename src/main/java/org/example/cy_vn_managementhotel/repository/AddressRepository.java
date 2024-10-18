package org.example.cy_vn_managementhotel.repository;

import org.example.cy_vn_managementhotel.entity.Address;
import org.example.cy_vn_managementhotel.utils.DBHepler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressRepository {
    public List<Address> findAllProvince() {
        List<Address> addressList = new ArrayList<>();
        String sql = "select * from address where id_province = 0 and id_district = 0 and id_commune = 0";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Address address = buildFromResultSet(resultSet);
                    addressList.add(address);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return addressList;
    }

    private Address buildFromResultSet(ResultSet resultSet) throws SQLException {
        return Address.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name_address"))
                .idProvince(resultSet.getLong("id_province"))
                .idCommune(resultSet.getLong("id_commune"))
                .idDistrict(resultSet.getLong("id_district"))
                .build();
    }
}
