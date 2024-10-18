package org.example.cy_vn_managementhotel.service;

import org.example.cy_vn_managementhotel.model.AccountResponse;

public interface IAccountService {
    AccountResponse checkLogin(String email, String password);
}
