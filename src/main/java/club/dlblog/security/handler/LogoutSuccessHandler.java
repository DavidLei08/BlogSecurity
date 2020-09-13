package club.dlblog.security.handler;


import club.dlblog.security.common.response.RestResponse;
import club.dlblog.security.utils.ServletUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 注销成功回调
 *
 * @author songyinyin
 * @date 2020/2/25 下午 09:28
 */
@Component
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        // TODO 登出成功 记录登出日志
        ServletUtils.render(request, response, RestResponse.success());
    }
}
