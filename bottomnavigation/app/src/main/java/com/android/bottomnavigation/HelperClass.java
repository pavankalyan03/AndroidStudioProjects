package com.android.bottomnavigation;

public class HelperClass {


    String username, email, password, gender, location, branch;

    public HelperClass(String username, String email, String password, String gender, String location, String branch) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.location = location;
        this.branch = branch;
    }

    public HelperClass() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBranch() {
        return gender;
    }

    public void setBranch(String gender) {
        this.gender = gender;
    }
}
