package org.example.cy_vn_managementhotel.service.impl;

import org.example.cy_vn_managementhotel.dto.BillDetailRequest;
import org.example.cy_vn_managementhotel.mapper.BillDetailMapper;
import org.example.cy_vn_managementhotel.repository.BillDetailRepository;
import org.example.cy_vn_managementhotel.service.IBillDetailService;

public class BillDetailService implements IBillDetailService {
    BillDetailRepository billDetailRepository = new BillDetailRepository();

    @Override
    public int insertBillDetail(BillDetailRequest billDetailRequest) {
        return billDetailRepository.insert(BillDetailMapper.toBillDetail(billDetailRequest));
    }

}
