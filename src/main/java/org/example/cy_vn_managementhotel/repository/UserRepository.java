package org.example.cy_vn_managementhotel.repository;

import org.example.cy_vn_managementhotel.entity.Account;
import org.example.cy_vn_managementhotel.entity.User;
import org.example.cy_vn_managementhotel.utils.DBHepler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    AccountRepository accountRepository = new AccountRepository();

    public User findById(Long id) {
        User user = null;
        String sql = "select * from user u where id = ?";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    user = buildFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from user u";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    User user = buildFromResultSet(resultSet);
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public int insert(User user) {
        int result = 0;
        String sql = "INSERT INTO `user` (`name`, `sdt`, `cccd`, `email`, `avt`, `id_account`, `status`) VALUES (?,?,?,?,?,?,?)";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSdt());
            preparedStatement.setString(3, user.getCccd());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getAvt());
            preparedStatement.setLong(6, user.getAccount().getId());
            preparedStatement.setString(7, user.getStatus());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int update(User user, Long id) {
        int result = 0;
        String sql = "update user set name = ?, sdt = ?, cccd = ?, email = ?, avt = ?, id_account = ?, status = ? where id = ?";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSdt());
            preparedStatement.setString(3, user.getCccd());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getAvt());
            preparedStatement.setLong(6, user.getAccount().getId());
            preparedStatement.setString(7, user.getStatus());
            preparedStatement.setLong(8, id);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    private User buildFromResultSet(ResultSet rs) throws SQLException {
        Long idAccount = rs.getLong("id_account");
        Account account = accountRepository.findById(idAccount);
        return User.builder()
                .name(rs.getString("name"))
                .sdt(rs.getString("sdt"))
                .avt(rs.getString("avt"))
                .email(rs.getString("email"))
                .cccd(rs.getString("cccd"))
                .account(account)
                .id(rs.getLong("id"))
                .status(rs.getString("status"))
                .build();
    }
}
