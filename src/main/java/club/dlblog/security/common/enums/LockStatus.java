package club.dlblog.security.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 锁定状态[0:未锁定;1:已锁定]
 *
 * @author dingmingyang
 * @date 2020/06/04/11:20
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LockStatus implements CodeEnum {


    /**
     * 未锁定
     */
    UN_LOCK("0", "未锁定"),

    /**
     * 已锁定
     */
    LOCK("1", "已锁定");


    private String code;
    private String message;

    private final static Logger log = LoggerFactory.getLogger(LockStatus.class);
    LockStatus() {
    }

    LockStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 反序列化时的初始化函数
     */
    @JsonCreator
    public static LockStatus getItem(@JsonProperty("code") String code) {
        for (LockStatus item : values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        log.warn("[LockStatus] 枚举反序列化异常：code={}", code);
        throw new IllegalArgumentException("请传入枚举类型：" + Arrays.toString(LockStatus.values()));
    }

    /**
     * code转枚举类型
     *
     * @param code code码
     * @return {@link LockStatus}
     * @author dingmingyang
     * @date 2020/6/5 11:36
     */
    public static LockStatus fromString(String code) {
        for (LockStatus b : LockStatus.values()) {
            if (b.code.equalsIgnoreCase(code)) {
                return b;
            }
        }
        log.warn("[LockStatus] 无此枚举：code={}", code);
        throw new IllegalArgumentException("请传入枚举类型：" + Arrays.toString(LockStatus.values()));
    }

    @Override
    public String getCode() {
        return this.code;
    }
}