package org.example.cy_vn_managementhotel.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bill extends BaseEntity{
    Long id;
    String codeBill;
    double totalPrice;
    String customerName;
    String customerPhone;
    String note;
    User user;
    int status;
}
