package ooh.chaos.exception;

import com.only.tech.base.result.ResultEnum;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private Integer code;

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = code;
    }
}
