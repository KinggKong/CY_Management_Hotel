package org.example.cy_vn_managementhotel.mapper;

import org.example.cy_vn_managementhotel.dto.BillDetailRequest;
import org.example.cy_vn_managementhotel.entity.Bill;
import org.example.cy_vn_managementhotel.entity.BillDetail;
import org.example.cy_vn_managementhotel.entity.Room;
import org.example.cy_vn_managementhotel.model.BillDetailResponse;
import org.example.cy_vn_managementhotel.model.BillResponse;

import java.util.ArrayList;
import java.util.List;

public class BillDetailMapper {
    public static BillDetail toBillDetail(BillDetailRequest billDetailRequest) {
        return BillDetail.builder()
                .room(billDetailRequest.getRoom())
                .price(billDetailRequest.getPrice())
                .typeRoom(billDetailRequest.getTypeRoom())
                .checkin(billDetailRequest.getCheckin())
                .checkout(billDetailRequest.getCheckout())
                .codeBill(billDetailRequest.getCodeBill())
                .status(billDetailRequest.getStatus())
                .build();
    }

    public static BillDetail toBillDetail(BillDetailResponse billDetailResponse) {
        return BillDetail.builder()
                .id(billDetailResponse.getId())
                .room(billDetailResponse.getRoom())
                .typeRoom(billDetailResponse.getTypeRoom())
                .checkin(billDetailResponse.getCheckin())
                .checkout(billDetailResponse.getCheckout())
                .codeBill(billDetailResponse.getCodeBill())
                .status(billDetailResponse.getStatus())
                .build();
    }

    public static List<BillDetailResponse> toListBillDetailResponse(List<BillDetail> billDetailList) {
        List<BillDetailResponse> billDetailResponseList = new ArrayList<>();
        for (BillDetail billDetail : billDetailList) {
            BillDetailResponse billDetailResponse = toBillResponse(billDetail);
            billDetailResponseList.add(billDetailResponse);
        }
        return billDetailResponseList;
    }

    public static BillDetailResponse toBillResponse(BillDetail billDetail) {
        return BillDetailResponse.builder()
                .id(billDetail.getId())
                .room(billDetail.getRoom())
                .price(billDetail.getPrice())
                .typeRoom(billDetail.getTypeRoom())
                .checkin(billDetail.getCheckin())
                .checkout(billDetail.getCheckout())
                .codeBill(billDetail.getCodeBill())
                .status(billDetail.getStatus())
                .build();
    }
}
