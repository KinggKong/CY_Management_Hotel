package org.example.cy_vn_managementhotel.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Hotel extends BaseEntity {
    Long id;
    String name;
    String specificAddress;
    int status;
    Address address;
}
