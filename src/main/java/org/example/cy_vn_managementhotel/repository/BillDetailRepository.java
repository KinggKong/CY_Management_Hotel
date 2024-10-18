package org.example.cy_vn_managementhotel.repository;

import org.example.cy_vn_managementhotel.entity.BillDetail;
import org.example.cy_vn_managementhotel.entity.Room;
import org.example.cy_vn_managementhotel.utils.DBHepler;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class BillDetailRepository {
    RoomRepository roomRepository = new RoomRepository();

    public List<BillDetail> findByBillId(String codeBill) {
        List<BillDetail> billDetails = new ArrayList<BillDetail>();
        String sql = "select * from bill_detail where code_bill = ?";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, codeBill);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    BillDetail billDetail = buildBillDetailFromResultSet(resultSet);
                    billDetails.add(billDetail);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return billDetails;
    }

    public int insert(BillDetail billDetail) {
        System.out.println("Checkin: " + billDetail.getCheckin());
        System.out.println("Checkout: " + billDetail.getCheckout());
        int result = 0;
        String sql = "INSERT INTO `bill_detail` (`id_room`, `price`, `type_room`, `checkin`, `checkout`, `code_bill`, `status`) VALUES (?,?,?,?,?,?,?)";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setLong(1, billDetail.getRoom().getId());
            preparedStatement.setDouble(2, billDetail.getPrice());
            preparedStatement.setString(3, billDetail.getTypeRoom());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(billDetail.getCheckin()), Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh")));
            preparedStatement.setTimestamp(5, Timestamp.valueOf(billDetail.getCheckout()), Calendar.getInstance(TimeZone.getTimeZone("Asia/Ho_Chi_Minh")));
            preparedStatement.setString(6, billDetail.getCodeBill());
            preparedStatement.setInt(7, billDetail.getStatus());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int delete(Long idBillDetail) {
        int result = 0;
        String sql = "DELETE FROM `bill_detail` WHERE `id` = ?";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, idBillDetail);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private BillDetail buildBillDetailFromResultSet(ResultSet resultSet) throws SQLException {
        Long idRoom = resultSet.getLong("id_room");
        Room room = roomRepository.findById(idRoom);
        return BillDetail.builder()
                .codeBill(resultSet.getString("code_bill"))
                .id(resultSet.getLong("id"))
                .room(room)
                .checkin(resultSet.getTimestamp("checkin").toLocalDateTime())
                .checkout(resultSet.getTimestamp("checkout").toLocalDateTime())
                .price(resultSet.getDouble("price"))
                .typeRoom(resultSet.getString("type_room"))
                .status(resultSet.getInt("status"))
                .build();

    }
}
