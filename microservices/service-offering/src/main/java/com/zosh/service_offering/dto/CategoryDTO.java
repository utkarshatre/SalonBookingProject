package com.zosh.service_offering.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private String image;
    private Long saloonid;
}
