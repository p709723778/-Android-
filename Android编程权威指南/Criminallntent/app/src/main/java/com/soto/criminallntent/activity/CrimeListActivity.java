package com.soto.criminallntent.activity;

import android.support.v4.app.Fragment;
import com.soto.criminallntent.view.CrimeListFragment;

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
