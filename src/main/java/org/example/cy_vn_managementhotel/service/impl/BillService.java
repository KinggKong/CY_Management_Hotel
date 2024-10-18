package org.example.cy_vn_managementhotel.service.impl;

import org.example.cy_vn_managementhotel.dto.BillRequest;
import org.example.cy_vn_managementhotel.mapper.BillMapper;
import org.example.cy_vn_managementhotel.repository.BillRepository;
import org.example.cy_vn_managementhotel.service.IBilllService;

public class BillService implements IBilllService {
    BillRepository billRepository = new BillRepository();

    @Override
    public int insertBill(BillRequest billRequest) {
        return billRepository.insert(BillMapper.toBill(billRequest));
    }
}
