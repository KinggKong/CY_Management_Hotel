package org.example.cy_vn_managementhotel.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.cy_vn_managementhotel.entity.Room;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BillDetailRequest {
    Room room;
    double price;
    String typeRoom;
    LocalDateTime checkin;
    LocalDateTime checkout;
    String codeBill;
    int status;
}
