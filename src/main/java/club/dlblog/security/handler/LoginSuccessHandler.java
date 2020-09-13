package club.dlblog.security.handler;

import club.dlblog.security.common.response.RestResponse;
import club.dlblog.security.common.service.SecurityLoginUser;
import club.dlblog.security.utils.ServletUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录成功处理逻辑
 *
 * @author songyinyin
 * @date 2020/2/25 下午 09:05
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        SecurityLoginUser securityLoginUser = (SecurityLoginUser) authentication.getPrincipal();
        // 不是密码登陆，需要重定向到前端首页
        ServletUtils.render(request, response, RestResponse.success(authentication));
    }
}
