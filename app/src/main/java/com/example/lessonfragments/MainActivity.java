package com.example.lessonfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IFragments {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private Fragment fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onOpenUrl(String url) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentWebView, new WebViewFragment(url))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        fragment1 = getSupportFragmentManager().findFragmentById(R.id.fragmentWebView);
        if (fragment1 != null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment1);
            fragmentTransaction.commit();
        }
    }
}