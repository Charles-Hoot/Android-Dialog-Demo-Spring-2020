package com.example.dialogdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements TrimDialogFragment.TrimDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button inputBTN = findViewById(R.id.inputBTN);
        inputBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Button Click", "Clicked the button");
                TrimDialogFragment trimDF = new TrimDialogFragment();
                trimDF.show(getSupportFragmentManager(), null);
            }
        });
    }

    @Override
    public void useTrimedInput() {
        Log.d("Callback","Positive button callback invoked" );
        EditText inputET = findViewById(R.id.inputET);
        String theInput = inputET.getText().toString().trim();
        TextView resultTV = findViewById(R.id.resultTV);
        resultTV.setText("<<"+theInput+">>");
    }

    @Override
    public void usePlainInput() {
        Log.d("Callback","Negative button callback invoked" );

    }
}
