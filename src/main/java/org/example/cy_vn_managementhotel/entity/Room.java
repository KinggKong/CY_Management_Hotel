package org.example.cy_vn_managementhotel.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room extends BaseEntity {
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
    String status;
}
