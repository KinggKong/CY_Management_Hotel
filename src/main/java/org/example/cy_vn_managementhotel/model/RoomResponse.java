package org.example.cy_vn_managementhotel.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.cy_vn_managementhotel.entity.Hotel;
import org.example.cy_vn_managementhotel.entity.TypeRoom;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoomResponse {
    Long id;
    String name;
    double price;
    String description;
    TypeRoom typeRoom;
    int numberOfBed;
    float rate;
    String image;
    int numberOfPerson;
    Hotel hotel;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String status;
}
