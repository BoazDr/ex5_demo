package com.boaz.dragonski.ex5_demo_app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class InputNumbersFrag extends Fragment {

    private EnteredNumberListener numbersListener;

    public InputNumbersFrag(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.enter_number, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText editTextEnterNumber = view.findViewById(R.id.enter_number_editText);
        //overriding functions
        editTextEnterNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable str) {}
            @Override
            public void beforeTextChanged(CharSequence str, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence str, int start, int before, int count) {
                if (str.length() == 5) {
                    numbersListener.OnNumberEntered(str);
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        numbersListener = (EnteredNumberListener) context;
    }


}
