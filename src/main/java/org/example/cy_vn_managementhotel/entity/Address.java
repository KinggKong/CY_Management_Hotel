package org.example.cy_vn_managementhotel.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {
    Long id;
    String name;
    Long idProvince;
    Long idDistrict;
    Long idCommune;
}
