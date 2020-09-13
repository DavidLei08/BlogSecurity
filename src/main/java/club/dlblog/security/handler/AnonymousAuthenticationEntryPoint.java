package club.dlblog.security.handler;

import club.dlblog.security.common.response.ResponseCode;
import club.dlblog.security.common.response.RestResponse;
import club.dlblog.security.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登录时访问无权限资源时的异常
 *
 * @author songyinyin
 * @date 2020/2/25 下午 08:53
 */
@Component
public class AnonymousAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final static Logger log  = LoggerFactory.getLogger(AnonymousAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        log.warn("用户需要登录，访问[{}]失败，AuthenticationException={}", request.getRequestURI(), e);

        ServletUtils.render(request, response, RestResponse.fail(ResponseCode.USER_NEED_LOGIN));
    }
}
