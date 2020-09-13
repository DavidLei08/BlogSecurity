package club.dlblog.security.common.service;

import club.dlblog.security.common.constant.SecurityConstant;
import club.dlblog.security.common.exception.SystemException;
import club.dlblog.security.common.response.ResponseCode;
import club.dlblog.security.common.vo.LoginUser;
import club.dlblog.security.common.vo.UserDetailsVO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author songyinyin
 * @date 2020/6/25 下午 10:32
 */
@Service
public class SecurityAuthServiceImpl<T extends LoginUser<M>, M extends UserDetailsVO> implements AuthService<T,M> {

    @Override
    public T loginUser() {
        try {
            LoginUser<M> loginUser = ((SecurityLoginUser<M>) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getLoginUser();
            return (T) loginUser;
        } catch (Exception e) {
            throw new SystemException(ResponseCode.CURRENT_USER_FAIL, e);
        }
    }

    @Override
    public String loginUsername(HttpServletRequest request) {
        return request.getParameter(SecurityConstant.SPRING_SECURITY_FORM_USERNAME_KEY);
    }

    @Override
    public String loginExtendKey(HttpServletRequest request) {
        return request.getParameter(SecurityConstant.EXTEND_KEY_PARAMETER);
    }

    @Override
    public String loginExtendType(HttpServletRequest request) {
        return request.getParameter(SecurityConstant.EXTEND_TYPE_PARAMETER);
    }

    /**
     * 用户登录扩展凭证，如手机号的验证码
     *
     * @param request
     */
    @Override
    public String loginExtendCredentials(HttpServletRequest request) {
        return request.getParameter(SecurityConstant.EXTEND_CREDENTIALS_PARAMETER);
    }
}
