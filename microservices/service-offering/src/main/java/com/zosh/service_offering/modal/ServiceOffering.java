package com.zosh.service_offering.modal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ServiceOffering {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    private int price;
    private int duration;
    @Column(nullable = false)
    private Long saloonId;
    @Column(nullable = false)
    private Long categoryId;
    private String image;
}
