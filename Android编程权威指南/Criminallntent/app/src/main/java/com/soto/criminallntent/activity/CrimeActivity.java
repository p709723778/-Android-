package com.soto.criminallntent.activity;

import android.support.v4.app.Fragment;
import android.view.Menu;

import com.soto.criminallntent.R;
import com.soto.criminallntent.view.CrimeFragment;

public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_crime, menu);
        return true;
    }
}
