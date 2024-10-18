package org.example.cy_vn_managementhotel.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.cy_vn_managementhotel.entity.Facility;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeRoomResponse {
    Long id;
    String name;
    Facility facility;
}
