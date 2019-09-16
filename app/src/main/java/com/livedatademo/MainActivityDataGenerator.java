package com.livedatademo;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

public class MainActivityDataGenerator extends ViewModel {

    private String TAG = this.getClass().getSimpleName();
    private MutableLiveData<String> myRandomNumber;

    public MutableLiveData<String> getNumber() {
        Log.d(TAG, "getNumber() called");
        if (myRandomNumber == null) {
            myRandomNumber = new MutableLiveData<>();
            generateNumber();
        }
        return myRandomNumber;
    }

    public void generateNumber() {
        Log.d(TAG, "generateNumber() called");
        final int min = 1;
        final int max = 10;
        String randomNumber = "Number : " + (new Random().nextInt((max - min) + 1) + min);
        Log.d(TAG, "Generated Password : " + myRandomNumber);
        myRandomNumber.setValue(randomNumber);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "onCleared() called");
    }

}