package org.example.cy_vn_managementhotel.mapper;

import org.example.cy_vn_managementhotel.dto.BillRequest;
import org.example.cy_vn_managementhotel.entity.Bill;
import org.example.cy_vn_managementhotel.model.BillResponse;

import java.util.ArrayList;
import java.util.List;

public class BillMapper {

    public static Bill toBill(BillRequest billRequest) {
        return Bill.builder()
                .codeBill(billRequest.getCodeBill())
                .totalPrice(billRequest.getTotalPrice())
                .note(billRequest.getNote())
                .customerPhone(billRequest.getCustomerPhone())
                .customerName(billRequest.getCustomerName())
                .user(billRequest.getUser())
                .status(billRequest.getStatus())
                .build();
    }

    public static List<BillResponse> toListBillResponse(List<Bill> billList) {
        List<BillResponse> billResponseList = new ArrayList<>();
        for (Bill bill : billList) {
            billResponseList.add(toBillResponse(bill));
        }
        return billResponseList;
    }

    public static BillResponse toBillResponse(Bill bill) {
        return BillResponse.builder()
                .id(bill.getId())
                .codeBill(bill.getCodeBill())
                .totalPrice(bill.getTotalPrice())
                .customerName(bill.getCustomerName())
                .customerPhone(bill.getCustomerPhone())
                .note(bill.getNote())
                .user(bill.getUser())
                .status(bill.getStatus())
                .build();
    }
}
