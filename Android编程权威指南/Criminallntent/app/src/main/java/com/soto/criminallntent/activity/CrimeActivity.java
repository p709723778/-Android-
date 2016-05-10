package com.soto.criminallntent.activity;

import android.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.app.FragmentManager;

import com.soto.criminallntent.R;
import com.soto.criminallntent.view.CrimeFragment;

public class CrimeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = new CrimeFragment();
            fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
        }
    }
}
