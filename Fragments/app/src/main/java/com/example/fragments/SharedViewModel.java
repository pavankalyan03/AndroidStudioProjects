package com.example.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<String> messageLiveData = new MutableLiveData<>();

    public void setMessage(String message) {
        messageLiveData.setValue(message);
    }

    public LiveData<String> getMessageLiveData() {
        return messageLiveData;
    }
}
