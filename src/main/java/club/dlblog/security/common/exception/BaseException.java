package club.dlblog.security.common.exception;


import org.springframework.core.NestedRuntimeException;

/**
 * 自定义异常基类
 *
 * @author songyinyin
 * @date 2020/1/17 17:07
 */

public class BaseException extends NestedRuntimeException {

    protected int code;

    public BaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BaseException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
