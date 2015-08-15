package com.example.pulkit.fragmenttransaction;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by pulkit on 8/15/15.
 */
public class MyDialog extends DialogFragment implements View.OnClickListener {
    Button buttonYes,buttonNo;
    Communicator communicator;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setCancelable(false);
        View view = inflater.inflate(R.layout.my_dialog, null);
        buttonYes = (Button) view.findViewById(R.id.buttonYes);
        buttonNo = (Button) view.findViewById(R.id.buttonNo);
        buttonNo.setOnClickListener(this);
        buttonYes.setOnClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        communicator = (Communicator) activity;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonYes) {
            dismiss();
            communicator.onDialogClick("yes was clicked");
        }else {
            dismiss();
            communicator.onDialogClick("No was clicked");
        }
    }

    interface Communicator {
       public void onDialogClick(String message);
    }
}
