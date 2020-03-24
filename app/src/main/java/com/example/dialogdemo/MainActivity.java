package com.example.dialogdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements TrimDialogFragment.TrimDialogListener {

    private MainViewModel myModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect to the model
        ViewModelProvider.Factory vmf = new
                ViewModelProvider.NewInstanceFactory();
        ViewModelProvider vmp = new ViewModelProvider(this, vmf);
        myModel = vmp.get(MainViewModel.class);

        // Listen for changes and update the display
        myModel.getDisplay().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextView resultTV = findViewById(R.id.resultTV);
                resultTV.setText(s);
            }
        });


        Button inputBTN = findViewById(R.id.inputBTN);
        inputBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Button Click", "Clicked the button");
                EditText inputET = findViewById(R.id.inputET);
                String theInput = inputET.getText().toString();
                if(theInput.equals("")){
                    usePlainInput();
                } else if (theInput.charAt(0)==' '
                        || theInput.charAt(theInput.length()-1)==' ' ) {
                    TrimDialogFragment trimDF = new TrimDialogFragment();
                    trimDF.show(getSupportFragmentManager(), null);
                } else {
                    usePlainInput();
                }
            }
        });
    }

    @Override
    public void useTrimedInput() {
        Log.d("Callback","Positive button callback invoked" );
        EditText inputET = findViewById(R.id.inputET);
        String theInput = inputET.getText().toString();
        myModel.useTrimedInput(theInput);
    }

    @Override
    public void usePlainInput() {
        Log.d("Callback","Negative button callback invoked" );
        EditText inputET = findViewById(R.id.inputET);
        String theInput = inputET.getText().toString();
        myModel.usePlainInput(theInput);

    }
}
