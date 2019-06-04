package com.only.tech.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHI ZUN BAO
 * @since 2019/1/20
 */
@Data
public class ContractIdAndTotalFeeDto implements Serializable {
    private String contractId;
    private Integer price;
    private Long vipCardId;
}
