package com.zosh.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ServiceDTO {
    private Long id;
    private String name;
    private String description;
    private int price;
    private int duration;
    private Long saloonId;
    private Long categoryId;
    private String image;
}
