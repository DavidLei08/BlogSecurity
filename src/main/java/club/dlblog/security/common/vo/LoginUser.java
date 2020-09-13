package club.dlblog.security.common.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * 登录用户
 *
 * @author null
 * @date 2020/06/03/15:53
 */

public class LoginUser<T extends UserDetailsVO> implements Serializable {

    /**
     * 用户
     */
    private T user;

    /**
     * 权限标识集合
     */
    private Set<String> permissions;

    /**
     * 角色集合
     */
    private Set<String> roles;

    /**
     * 获取当前用户菜单集合
     */
    private Set<String> resources;

    /**
     * 登录ip
     */
    private String loginIp;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;


    /**
     * 用户密码
     */
    private String password;

    public LoginUser() {
    }

    public LoginUser(T user, String loginIp, LocalDateTime loginTime,String password) {
        this.user = user;
        this.loginIp = loginIp;
        this.loginTime = loginTime;
        this.password = password;
    }

    public LoginUser(T user, String loginIp, LocalDateTime loginTime) {
        this.user = user;
        this.loginIp = loginIp;
        this.loginTime = loginTime;
    }

    /**
     * 是否为管理员
     *
     * @author songyinyin
     * @date 2020/5/12
     */
    public boolean isAdmin() {
        return "1".equals(this.getUser().getUserId());
    }

    public T getUser() {
        return user;
    }

    public void setUser(T user) {
        this.user = user;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getResources() {
        return resources;
    }

    public void setResources(Set<String> resources) {
        this.resources = resources;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}