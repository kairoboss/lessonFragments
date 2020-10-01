package com.example.lessonfragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class textFragment extends Fragment {
    IFragments iFragments;
    private EditText etUrl;
    private Button btnSearch;

    public textFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iFragments = (IFragments) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_text, container, false);
        btnSearch  = v.findViewById(R.id.btn_search);
        etUrl = v.findViewById(R.id.etUrl);

        return v;
    }
}