package org.example.cy_vn_managementhotel.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.cy_vn_managementhotel.entity.User;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BillRequest {
    String codeBill;
    double totalPrice;
    String customerName;
    String customerPhone;
    String note;
    User user;
    int status;
}
