package com.zosh.modal;

import lombok.Data;

@Data
public class SaloonReport {
   private Long saloonID;
   private String saloonName;
   private int totalEarning;
   private Integer totalBooking;
   private Integer cancelledBooking;
   private Double totalRefund;
}
