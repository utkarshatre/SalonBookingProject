package com.zosh.salon.services.payloadDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
//@AllArgsConstructor   //all three have same meaning equals to Data
//@Getter
//@Setter
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
}

