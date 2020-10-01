package com.example.lessonfragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class changeFragment extends Fragment {
    private TextView textView;
    private IFragments fragments;
    FragmentActivity fragmentActivity = getActivity();
    RecyclerView recyclerView;
    List<String> items;


    public changeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragments = (IFragments) context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_change, container, false);
        items = new ArrayList<String>();
        items.add("https://www.youtube.com/?hl=ru");
        items.add("https://github.com/");
        items.add("https://vk.com/");
        items.add("https://www.instagram.com/?hl=ru");
        items.add("https://developer.android.com/");
        items.add("https://ok.ru/");
        items.add("https://mail.ru/");
        items.add("http://news.torrent.kg/");
        items.add("https://oc.kg/");
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(fragmentActivity));
        Adapter adapter = new Adapter(items,fragmentActivity, (IFragments) getActivity());
        recyclerView.setAdapter(adapter);
        return v;
    }

    public void showText(String text) {
        textView.setText(text);
    }
}