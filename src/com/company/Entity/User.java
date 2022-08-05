//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.company.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
        name = "userdata"
)
public class User {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "userId"
    )
    private int userId;
    @Column(
            name = "userName"
    )
    private String userName;
    @Column(
            name = "userPass"
    )
    private String userPass;
    @Column(
            name = "role"
    )
    private String role;
    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_USER = "user";

    public User() {
    }

    public User(int userId, String userName, String userPass, String role) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
        this.role = role;
    }

    public User(String userName, String userPass, String role) {
        this.userName = userName;
        this.userPass = userPass;
        this.role = role;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return this.userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString() {
        return "User{userId=" + this.userId + ", userName='" + this.userName + '\'' + ", userPass='" + this.userPass + '\'' + ", role='" + this.role + '\'' + '}';
    }
}
