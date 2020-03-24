package com.example.dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class TrimDialogFragment extends DialogFragment {

    public interface TrimDialogListener {
        public void useTrimedInput();
        public void usePlainInput();
    }

    private TrimDialogListener myActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        myActivity = (TrimDialogListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //return super.onCreateDialog(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Do you need a trim?");
        builder.setMessage("Your input has spaces at the beginning or end.  Do you want to remove those spaces before using the input?");
        builder.setPositiveButton("Trim the spaces.",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Dialog Click", "Positive Dialog Button pressed");
                        myActivity.useTrimedInput();
                    }
                });
        return builder.create();
    }
}
