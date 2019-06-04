package com.only.tech.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class FaqRespDto implements Serializable {

    /**
     * 问题
     */
    @ApiModelProperty(value = "问题", name = "question")
    private String question;

    /**
     * 回答
     */
    @ApiModelProperty(value = "回答", name = "answer")
    private String answer;

}
