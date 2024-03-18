package com.android.model;

import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {
    private String sharedData;

    public String getSharedData() {
        return sharedData;
    }

    public void setSharedData(String sharedData) {
        this.sharedData = sharedData;
    }
}
