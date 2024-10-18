package org.example.cy_vn_managementhotel.service.impl;

import org.example.cy_vn_managementhotel.entity.Account;
import org.example.cy_vn_managementhotel.mapper.AccountMapper;
import org.example.cy_vn_managementhotel.model.AccountResponse;
import org.example.cy_vn_managementhotel.repository.AccountRepository;
import org.example.cy_vn_managementhotel.service.IAccountService;

public class AccountService implements IAccountService {
    AccountRepository accountRepository = new AccountRepository();

    @Override
    public AccountResponse checkLogin(String email, String password) {
        Account account = accountRepository.checkLoginByUsernameAndPassword(email, password);
        return AccountMapper.toAccountResponse(account);
    }
}
