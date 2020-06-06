package com.cs.blogger.Model;
/**
 * Created by Shivam Singh Rathore on 17/05/20
 *
 */
public class Users {

    public   String fullname;
    public  String username;
    public String emailid;
    public  String password;
    public  String phoneNo;

    public Users() {
    }

    public Users(String fullname, String username, String emailid, String password, String phoneNo) {
        this.fullname = fullname;
        this.username = username;
        this.emailid = emailid;
        this.password = password;
        this.phoneNo = phoneNo;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
