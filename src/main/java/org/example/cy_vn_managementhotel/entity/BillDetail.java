package org.example.cy_vn_managementhotel.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BillDetail extends BaseEntity{
    Long id;
    Room room;
    double price;
    String typeRoom;
    LocalDateTime checkin;
    LocalDateTime checkout;
    String codeBill;
    int status;
}
