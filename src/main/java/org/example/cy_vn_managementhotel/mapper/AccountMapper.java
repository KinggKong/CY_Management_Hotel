package org.example.cy_vn_managementhotel.mapper;

import org.example.cy_vn_managementhotel.entity.Account;
import org.example.cy_vn_managementhotel.model.AccountResponse;

public class AccountMapper {
    public static AccountResponse toAccountResponse(Account account) {
        return AccountResponse.builder()
                .password(account.getPassword())
                .username(account.getUsername())
                .role(account.getRole())
                .id(account.getId())
                .build();
    }
}
