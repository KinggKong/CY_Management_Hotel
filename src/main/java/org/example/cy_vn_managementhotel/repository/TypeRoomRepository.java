package org.example.cy_vn_managementhotel.repository;

import org.example.cy_vn_managementhotel.entity.Facility;
import org.example.cy_vn_managementhotel.entity.TypeRoom;
import org.example.cy_vn_managementhotel.utils.DBHepler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TypeRoomRepository {

    public TypeRoom findById(Long id) {
        TypeRoom typeRoom = null;
        String sql = "select tr.*,f.name as name_facility, f.description, f.created_at, f.updated_at, f.status from type_room tr\n" +
                "inner join facilities f on f.id = tr.id_facilities where tr.id = ?";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
               while (resultSet.next()) {
                   typeRoom = buildFromResultSet(resultSet);
               }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeRoom;
    }

    private TypeRoom buildFromResultSet(ResultSet resultSet) throws SQLException {
        Facility facility = Facility.builder()
                .id(resultSet.getLong("id_facilities"))
                .name(resultSet.getString("name_facility"))
                .description(resultSet.getString("description"))
                .build();
        return TypeRoom.builder()
                .facility(facility)
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .build();
    }

}
