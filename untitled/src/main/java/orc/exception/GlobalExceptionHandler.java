package orc.exception;

import orc.entity.POSTDTO.ResponseResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常处理器，处理所有Controller层的异常
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 处理自定义业务异常
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ResponseResult<Void>> handleBusinessException(BusinessException e) {
        ResponseResult<Void> result = new ResponseResult<>(e.getCode(), e.getMessage(), null);
        return new ResponseEntity<>(result, HttpStatus.valueOf(e.getCode()));
    }

    // 处理其他未捕获的异常
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseResult<Void>> handleException(Exception e) {
        ResponseResult<Void> result = new ResponseResult<>(500, "服务器内部错误: " + e.getMessage(), null);
        return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}