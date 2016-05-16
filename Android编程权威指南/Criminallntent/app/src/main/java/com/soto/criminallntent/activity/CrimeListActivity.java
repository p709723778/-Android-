package com.soto.criminallntent.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import com.soto.criminallntent.R;
import com.soto.criminallntent.view.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);


    }
}
