package club.dlblog.security.utils;

import club.dlblog.security.common.service.SecurityLoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static  SecurityLoginUser getAuthUser(){
        SecurityLoginUser securityLoginUser = null;
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();

        if(authentication==null){
            return securityLoginUser;
        }
        Object o = authentication.getPrincipal();
        if(o instanceof SecurityLoginUser ) {
            securityLoginUser = (SecurityLoginUser) o;
        }
        return  securityLoginUser;
    }




}
