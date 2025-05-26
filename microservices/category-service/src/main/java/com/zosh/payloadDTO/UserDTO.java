package com.zosh.payloadDTO;

import lombok.Data;

@Data
//@AllArgsConstructor   //all three have same meaning equals to Data
//@Getter
//@Setter
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
}

