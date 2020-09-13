package club.dlblog.security.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * 性别[0:女;1:男]
 *
 * @author dingmingyang
 * @date 2020/06/04/16:30
 */

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Sex implements CodeEnum {
    /**
     * 女
     */
    WOMAN("0", "女"),
    /**
     * 男
     */
    MAN("1", "男");

    private String code;
    private String message;

    private final static Logger log = LoggerFactory.getLogger(Sex.class);

    Sex() {
    }

    Sex(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 反序列化时的初始化函数
     */
    @JsonCreator
    public static Sex getItem(@JsonProperty("code") String code) {
        for (Sex item : values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        log.warn("[Sex] 枚举反序列化异常：code={}", code);
        throw new IllegalArgumentException("请传入枚举类型：" + Arrays.toString(Sex.values()));
    }


    /**
     * code转枚举类型
     *
     * @param code code码
     * @return {@link Sex}
     * @author dingmingyang
     * @date 2020/6/5 11:36
     */
    public static Sex fromString(String code) {
        for (Sex b : Sex.values()) {
            if (b.code.equalsIgnoreCase(code)) {
                return b;
            }
        }
        log.warn("[Sex] 无此枚举：code={}", code);
        throw new IllegalArgumentException("请传入枚举类型：" + Arrays.toString(Sex.values()));
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
