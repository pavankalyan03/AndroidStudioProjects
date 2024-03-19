package com.android.realtimeregister;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {
    private MutableLiveData<String> gender = new MutableLiveData<>("");
    private MutableLiveData<String> location = new MutableLiveData<>("");
    private MutableLiveData<String> email = new MutableLiveData<>("");
    private MutableLiveData<String> username = new MutableLiveData<>("");
    private MutableLiveData<String> password = new MutableLiveData<>("");

    public LiveData<String> getGender() {
        return gender;
    }

    public void setGender(String value) {
        gender.setValue(value);
    }

    public LiveData<String> getLocation() {
        return location;
    }

    public void setLocation(String value) {
        location.setValue(value);
    }

    public LiveData<String> getEmail() {
        return email;
    }

    public void setEmail(String value) {
        email.setValue(value);
    }

    public LiveData<String> getUsername() {
        return username;
    }

    public void setUsername(String value) {
        username.setValue(value);
    }

    public LiveData<String> getPassword() {
        return password;
    }
    public void setPassword(String value) {
        password.setValue(value);
    }

}
