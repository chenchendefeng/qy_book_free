package com.only.tech.dto.tadu;

import lombok.Data;

/**
 * @author ZHI ZUN BAO
 * @since 2019/4/26
 */
@Data
public class TaduResultDto<T> {

    private String code;

    private String msg;

    private T data;
}
