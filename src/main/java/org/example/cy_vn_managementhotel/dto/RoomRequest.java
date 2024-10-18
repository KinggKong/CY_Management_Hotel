package org.example.cy_vn_managementhotel.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.cy_vn_managementhotel.entity.Hotel;
import org.example.cy_vn_managementhotel.entity.TypeRoom;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomRequest {
    String name;
    double price;
    String description;
    TypeRoom typeRoom;
    int numberOfBed;
    float rate;
    String image;
    int numberOfPerson;
    Hotel hotel;
    String status;
}
