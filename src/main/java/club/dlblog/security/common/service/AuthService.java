package club.dlblog.security.common.service;

import club.dlblog.security.common.vo.LoginUser;
import club.dlblog.security.common.vo.UserDetailsVO;


import javax.servlet.http.HttpServletRequest;

/**
 * 权限抽象接口
 *
 * @author songyinyin
 * @date 2020/6/25 下午 10:30
 */
public interface AuthService<T extends LoginUser<M>, M extends UserDetailsVO> {

    /**
     * 获取登录用户
     */
    T loginUser();

    /**
     * 从登录请求中，获取登录用户的用户名
     */
    String loginUsername(HttpServletRequest request) ;

    /**
     * 从登录请求中，获取扩展登录的 extendKey
     */
    String loginExtendKey(HttpServletRequest request);

    /**
     * 从登录请求中，获取扩展登录的 extendType
     */
    String loginExtendType(HttpServletRequest request);

    /**
     * 用户登录扩展凭证，如手机号的验证码
     */
    String loginExtendCredentials(HttpServletRequest request);

}
