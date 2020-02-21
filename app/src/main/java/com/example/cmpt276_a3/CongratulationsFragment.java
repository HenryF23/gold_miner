package com.example.cmpt276_a3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class CongratulationsFragment extends AppCompatDialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(
                R.layout.congratulations_dialog_box, null);

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        getActivity().finish();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

        return new AlertDialog.Builder(getActivity())
                .setTitle("Congratulations !")
                .setView(view)
                .setPositiveButton(android.R.string.ok, listener)
                .setNeutralButton(android.R.string.cancel, listener)
                .create();
    }
}
