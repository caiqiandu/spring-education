package com.jk.model;

/**
 * @author ：mmzs
 * @date ：Created in 2019/4/15 19:24
 * @description：
 * @modified By：
 * @version: $
 */
public class User {
    private Integer id;
    private String name;
    private String loginnumber;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginnumber() {
        return loginnumber;
    }

    public void setLoginnumber(String loginnumber) {
        this.loginnumber = loginnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loginnumber='" + loginnumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
