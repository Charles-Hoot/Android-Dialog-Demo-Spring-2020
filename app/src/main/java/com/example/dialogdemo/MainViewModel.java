package com.example.dialogdemo;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<String> theInput = new MutableLiveData<String>();

    public void usePlainInput(String input) {
        theInput.setValue(input);
    }

    public void useTrimedInput(String input) {
        theInput.setValue(input.trim());
    }

    private LiveData<String> displayString =
            Transformations.map(theInput,
                    (s) -> "<<" + theInput.getValue() + ">>");
    public LiveData<String> getDisplay() {
        return displayString;
    }
}
