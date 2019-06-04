package ooh.chaos.controller;




import com.only.tech.base.result.ResultDto;
import com.only.tech.base.result.ResultString;
import lombok.extern.slf4j.Slf4j;
import ooh.chaos.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class GlobalDefultExceptionHandler {

    //声明要捕获的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultDto defultExcepitonHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        ResultDto resultDto = null;
        if (e instanceof BusinessException) {
            log.error("业务异常：" + e.getMessage());
            BusinessException businessException = (BusinessException) e;
            resultDto = ResultDto.responseResult(businessException.getCode() + "", businessException.getMessage());
            return resultDto;
        }
        //未知错误
        resultDto = ResultDto.responseResult(ResultString.ERROR, "系统异常");
        return resultDto;
    }

}

