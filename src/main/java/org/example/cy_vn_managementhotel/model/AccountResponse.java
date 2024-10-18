package org.example.cy_vn_managementhotel.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.cy_vn_managementhotel.entity.Role;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponse {
    Long id;
    String username;
    String password;
    Role role;
}
