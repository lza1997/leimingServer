package cn.zhang.bean;

/**
 * 后台管理人员
 * 
 * @author ZhangYaxu
 * @date 2015年8月6日
 */
public class Admin {
    private Integer id;
    private String loginName;
    private String password;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
