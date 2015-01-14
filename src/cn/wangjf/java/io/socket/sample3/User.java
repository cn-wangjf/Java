package cn.wangjf.java.io.socket.sample3;

import java.io.Serializable;

/**
 * User: wangjf
 * Date: 15-1-12
 * Time: 下午2:34
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String password;

    public User() {

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
