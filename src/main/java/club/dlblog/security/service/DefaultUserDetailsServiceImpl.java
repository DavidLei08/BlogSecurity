package club.dlblog.security.service;


import club.dlblog.security.common.enums.LockStatus;
import club.dlblog.security.common.enums.StopStatus;
import club.dlblog.security.common.service.SecurityLoginUser;
import club.dlblog.security.common.vo.LoginUser;
import club.dlblog.security.common.vo.UserDetailsVO;
import club.dlblog.security.utils.IpUtils;
import club.dlblog.security.utils.ServletUtils;
import org.apache.catalina.security.SecurityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * @author songyinyin
 * @date 2020/2/19 下午 10:18
 */
@Service
public class DefaultUserDetailsServiceImpl implements UserDetailsService {


    private final static Logger log  = LoggerFactory.getLogger(DefaultUserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            log.info("登录用户：{} 不存在", username);
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }

        // 查出密码
        // 查出密码
        LoginUser<UserDetailsVO> data = new LoginUser<>();
        LoginUser<UserDetailsVO> loginUser = data;
        loginUser.setLoginIp(IpUtils.getIpAddr(ServletUtils.getRequest()));
        UserDetailsVO userDetailsVO = new UserDetailsVO();
        userDetailsVO.setUserId("11");
        userDetailsVO.setPwdLockStatus(LockStatus.UN_LOCK);
        userDetailsVO.setStopStatus(StopStatus.ENABLE);

        loginUser.setUser(userDetailsVO);
        loginUser.setLoginTime(LocalDateTime.now());
        BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();
        loginUser.setPassword(encoder.encode("kkkkkkkkkkk"));
        return new SecurityLoginUser<>(loginUser);
    }

}
