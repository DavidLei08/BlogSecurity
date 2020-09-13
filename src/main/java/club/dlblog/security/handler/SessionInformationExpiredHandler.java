package club.dlblog.security.handler;

import club.dlblog.security.common.response.ResponseCode;
import club.dlblog.security.common.response.RestResponse;
import club.dlblog.security.utils.ServletUtils;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * 超出最大登录数，用户被踢出后处理方法
 *
 * @author songyinyin
 * @date 2020/2/25 下午 09:55
 */
@Component
public class SessionInformationExpiredHandler implements SessionInformationExpiredStrategy {

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent sessionInformationExpiredEvent) throws IOException, ServletException {

        ServletUtils.render(sessionInformationExpiredEvent.getRequest(),
                sessionInformationExpiredEvent.getResponse(), RestResponse.fail(ResponseCode.USER_MAX_LOGIN));
    }
}
