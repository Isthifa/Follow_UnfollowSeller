package com.agritrade.user.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerFollowedDTO {
    private String sellerName;
    private String companyName;

    private Boolean FollowedStatus;
}
