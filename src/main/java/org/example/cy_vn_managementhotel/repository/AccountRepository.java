package org.example.cy_vn_managementhotel.repository;

import org.example.cy_vn_managementhotel.entity.Account;
import org.example.cy_vn_managementhotel.entity.Role;
import org.example.cy_vn_managementhotel.utils.DBHepler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {
    public Account checkLoginByUsernameAndPassword(String username, String password) {
        Account account = null;
        String sql = "select * from account\n" +
                "inner join role on role.id = account.id_role\n" +
                " where username = ? and password = ?";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    account = buildFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }

    public int insertAccount(Account account) {
        int result = 0;
        String sql = "insert into account(usename,passwrod,id_role) values(?,?,?)";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setLong(3, account.getRole().getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int updateAccount(Account account, Long idAccount) {
        int result = 0;
        String sql = "update account set username = ? , password = ?, id_role = ? where id = ?";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setLong(3, account.getRole().getId());
            preparedStatement.setLong(4, idAccount);
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    public Account findById(Long id) {
        Account account = null;
        String sql = "select ac.*,r.name,r.status from account ac\n" +
                "inner join  role r on r.id = ac.id_role where ac.id = ?";
        try (Connection connection = DBHepler.openConnectionToDB();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    account = buildFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }

    private Account buildFromResultSet(ResultSet resultSet) throws SQLException {
        Role role = Role.builder()
                .id(resultSet.getLong("id_role"))
                .name(resultSet.getString("name"))
                .status(resultSet.getInt("status"))
                .build();
        return Account.builder()
                .id(resultSet.getLong("id"))
                .role(role)
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .build();
    }
}
