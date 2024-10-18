package org.example.cy_vn_managementhotel.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User extends BaseEntity {
    Long id;
    String name;
    String sdt;
    String cccd;
    String email;
    String avt;
    Account account;
    String status;
}
