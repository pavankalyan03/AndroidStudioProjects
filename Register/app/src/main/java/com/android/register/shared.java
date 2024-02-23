package com.android.register;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class shared extends ViewModel {
    private final MutableLiveData<String> f = new MutableLiveData<>();
    private final MutableLiveData<String> l= new MutableLiveData<>();
    private final MutableLiveData<String> g= new MutableLiveData<>();
    private final MutableLiveData<String> d = new MutableLiveData<>();
    private final MutableLiveData<String> a = new MutableLiveData<>();

    public void setFname(String fname) {
        f.setValue(fname);
    }

    public LiveData<String> getFname() {
        return f;
    }

    public void setLname(String lname) {
        l.setValue(lname);
    }

    public LiveData<String> getLname() {
        return l;
    }
    public void setGen(String gen) {
        g.setValue(gen);
    }

    public LiveData<String> getGen() {
        return g;
    }
    public void setDob(String dob) {
        d.setValue(dob);
    }

    public LiveData<String> getDob() {
        return d;
    }
    public void setAddr(String addr) {
        a.setValue(addr);
    }

    public LiveData<String> getAddr() {
        return a;
    }
}
