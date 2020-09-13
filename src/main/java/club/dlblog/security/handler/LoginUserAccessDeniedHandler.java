package club.dlblog.security.handler;

import club.dlblog.security.common.response.ResponseCode;
import club.dlblog.security.common.response.RestResponse;
import club.dlblog.security.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录用户没有权限访问资源
 *
 * @author songyinyin
 * @date 2020/3/18 下午 09:08
 */
@Component
public class LoginUserAccessDeniedHandler implements AccessDeniedHandler {

    private final static Logger log = LoggerFactory.getLogger(LoginUserAccessDeniedHandler.class);

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.warn("用户无权访问", accessDeniedException);
        ServletUtils.render(request, response, RestResponse.build(ResponseCode.NO_AUTHENTICATION));
    }
}
