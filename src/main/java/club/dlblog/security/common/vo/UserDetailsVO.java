package club.dlblog.security.common.vo;

import club.dlblog.security.common.constant.SecurityConstant;
import club.dlblog.security.common.enums.LockStatus;
import club.dlblog.security.common.enums.Sex;
import club.dlblog.security.common.enums.StopStatus;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 用户对象
 *
 * @author songyinyin
 * @date 2020/3/26 下午 09:18
 */

public class UserDetailsVO implements Serializable {

    private static final long serialVersionUID = SecurityConstant.SERIAL_VERSION_UID;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 所属机构代码
     */
    private String orgId;

    /**
     * 用户名，登录名【不能为中文】
     */
    private String userName;

    /**
     * sessionId
     */
    private String sessionId;

    /**
     * 昵称、姓名
     */
    private String nickName;

    /**
     * session   登录ip
     */
    private String loginIp;


    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别[0:女;1:男]
     */
    private Sex sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 微信号
     */
    private String wechat;

    /**
     * 备注
     */
    private String remark;

    /**
     * 密码修改时间
     */
    private LocalDateTime pwdUpdateTime;

    /**
     * 启停状态[0:启用;1:停用]
     */
    private StopStatus stopStatus;

    /**
     * 停用时间
     */
    private LocalDateTime stopTime;

    /**
     * 停用原因
     */
    private String stopReason;

    /**
     * 密码错误次数
     */
    private BigDecimal pwdErrorNumber;

    /**
     * 密码锁定状态[0:未锁定;1:已锁定]
     */
    private LockStatus pwdLockStatus;

    /**
     * 用户锁定时间
     */
    private LocalDateTime lockTime;

    /**
     * 最近成功登陆时间
     */
    private LocalDateTime loginSuccessTime;

    /**
     * 编辑用户
     */
    private String updateUserId;

    /**
     * 编辑时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建用户
     */
    private String createUserId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getPwdUpdateTime() {
        return pwdUpdateTime;
    }

    public void setPwdUpdateTime(LocalDateTime pwdUpdateTime) {
        this.pwdUpdateTime = pwdUpdateTime;
    }

    public StopStatus getStopStatus() {
        return stopStatus;
    }

    public void setStopStatus(StopStatus stopStatus) {
        this.stopStatus = stopStatus;
    }

    public LocalDateTime getStopTime() {
        return stopTime;
    }

    public void setStopTime(LocalDateTime stopTime) {
        this.stopTime = stopTime;
    }

    public String getStopReason() {
        return stopReason;
    }

    public void setStopReason(String stopReason) {
        this.stopReason = stopReason;
    }

    public BigDecimal getPwdErrorNumber() {
        return pwdErrorNumber;
    }

    public void setPwdErrorNumber(BigDecimal pwdErrorNumber) {
        this.pwdErrorNumber = pwdErrorNumber;
    }

    public LockStatus getPwdLockStatus() {
        return pwdLockStatus;
    }

    public void setPwdLockStatus(LockStatus pwdLockStatus) {
        this.pwdLockStatus = pwdLockStatus;
    }

    public LocalDateTime getLockTime() {
        return lockTime;
    }

    public void setLockTime(LocalDateTime lockTime) {
        this.lockTime = lockTime;
    }

    public LocalDateTime getLoginSuccessTime() {
        return loginSuccessTime;
    }

    public void setLoginSuccessTime(LocalDateTime loginSuccessTime) {
        this.loginSuccessTime = loginSuccessTime;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
