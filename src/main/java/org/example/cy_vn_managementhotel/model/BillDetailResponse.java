package org.example.cy_vn_managementhotel.model;

import lombok.AccessLevel;
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
public class BillDetailResponse {
    Long id;
    Room room;
    double price;
    String typeRoom;
    LocalDateTime checkin;
    LocalDateTime checkout;
    String codeBill;
    int status;
}
