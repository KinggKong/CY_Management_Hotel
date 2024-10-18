package org.example.cy_vn_managementhotel.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Common {
    private int totalPage;
    private int totalItem;
    private int pageIndex;
    private String message;
    private List<RoomResponse> list = new ArrayList<>();
}