package com.soto.criminallntent.view;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.soto.criminallntent.R;
import com.soto.criminallntent.model.Crime;
import com.soto.criminallntent.model.CrimeLab;

import java.util.ArrayList;


public class CrimeListFragment extends ListFragment {

    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crime_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();
    }
}
