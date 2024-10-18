package org.example.cy_vn_managementhotel.repository;

import org.example.cy_vn_managementhotel.entity.Bill;
import org.example.cy_vn_managementhotel.entity.User;
import org.example.cy_vn_managementhotel.utils.DBHepler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillRepository {
    UserRepository userRepository = new UserRepository();

    public List<Bill> findAll() {
        List<Bill> bills = new ArrayList<>();
        String sql = "select * from bill";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Bill bill = buildFromResultSet(resultSet);
                    bills.add(bill);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bills;
    }

    public int insert(Bill bill) {
        int result = 0;
        String sql = "INSERT INTO `bill` (`code_bill`, `total_price`, `customer_name`, `customer_phone`, `note`, `id_user`, `status`) VALUES (?,?,?,?,?,?,?)";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, bill.getCodeBill());
            preparedStatement.setDouble(2, bill.getTotalPrice());
            preparedStatement.setString(3, bill.getCustomerName());
            preparedStatement.setString(4, bill.getCustomerPhone());
            preparedStatement.setString(5, bill.getNote());
            preparedStatement.setLong(6, bill.getUser().getId());
            preparedStatement.setInt(7, bill.getStatus());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int update(Bill bill,Long id) {
        int result = 0;
        String sql = "INSERT INTO `bill` (`code_bill`, `total_price`, `customer_name`, `customer_phone`, `note`, `id_user`, `status`) VALUES (?,?,?,?,?,?,?)";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, bill.getCodeBill());
            preparedStatement.setDouble(2, bill.getTotalPrice());
            preparedStatement.setString(3, bill.getCustomerName());
            preparedStatement.setString(4, bill.getCustomerPhone());
            preparedStatement.setString(5, bill.getNote());
            preparedStatement.setLong(6, bill.getUser().getId());
            preparedStatement.setInt(7, bill.getStatus());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private Bill buildFromResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id_user");
        User user = userRepository.findById(id);
        return Bill.builder()
                .id(resultSet.getLong("id"))
                .user(user)
                .codeBill(resultSet.getString("code_bill"))
                .totalPrice(resultSet.getDouble("total_price"))
                .customerName(resultSet.getString("customer_name"))
                .customerPhone(resultSet.getString("customer_phone"))
                .note(resultSet.getString("note"))
                .status(resultSet.getInt("status"))
                .build();
    }
}
