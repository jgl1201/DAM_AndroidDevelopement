package com.example.a003_bottomnavigation.ui.nuevo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NuevoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public NuevoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}