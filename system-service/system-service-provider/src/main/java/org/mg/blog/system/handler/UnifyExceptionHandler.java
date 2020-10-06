
package org.mg.blog.system.handler;

import lombok.extern.slf4j.Slf4j;

import org.mg.blog.dto.Result;
import org.mg.blog.dto.Status;
import org.mg.blog.resp.ErrorResp;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理器
 *
 * @since 2020-09-28
 */
@Slf4j
@ControllerAdvice
public class UnifyExceptionHandler {

    /**
     * 异常处理器
     *
     * @param e 异常信息
     * @return 错误数据
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<ErrorResp> error(Exception e) {
        log.error("exception: {}", e.getMessage());

        ErrorResp errorResp = new ErrorResp();
        errorResp.setErrorDesc("Internal Error");

        Result<ErrorResp> result = new Result<>();
        result.setStatus(Status.INTERNAL_ERROR);
        result.setResult(errorResp);
        return result;
    }
}
