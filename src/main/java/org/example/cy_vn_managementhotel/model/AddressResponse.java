package org.example.cy_vn_managementhotel.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressResponse {
    Long id;
    String name;
    Long idProvince;
    Long idDistrict;
    Long idCommune;
}
