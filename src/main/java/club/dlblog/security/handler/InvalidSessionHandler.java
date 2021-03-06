package club.dlblog.security.handler;

import club.dlblog.security.common.response.ResponseCode;
import club.dlblog.security.common.response.RestResponse;
import club.dlblog.security.utils.ServletUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录后，当达到超时时间后，自动将用户退出登录
 *
 * @author songyinyin
 * @date 2020/2/25 下午 10:45
 */
@Component
public class InvalidSessionHandler implements InvalidSessionStrategy {

    private final static Logger log  = LoggerFactory.getLogger(InvalidSessionHandler.class);


    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.info("用户登录超时，访问[{}]失败", request.getRequestURI());
        request.getSession().invalidate();
        ServletUtils.render(request, response, RestResponse.fail(ResponseCode.USER_LOGIN_TIMEOUT));
    }
}
