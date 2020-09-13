package club.dlblog.security.controller;

import club.dlblog.security.utils.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @RequestMapping("/test")
    public Object test(){
        return SecurityUtils.getAuthUser();
    }

}
