package com.soto.criminallntent.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Soto on 16/5/13.
 */
public class CrimeLab {


    private ArrayList<Crime> mCrimes;

    private static CrimeLab sCrimeLab;

    private Context mAppCotext;


    private CrimeLab(Context context) {
        mAppCotext = context;
        mCrimes = new ArrayList<Crime>();
        for (int i = 0; i < 100; i++) {
            Crime c = new Crime();
            c.setTitle("Crime #" + i);
            c.setSolved(i % 2 == 0);
            mCrimes.add(c);
        }
    }

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }


    public Crime getCrime(UUID id) {
        for (Crime c : getCrimes()) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }
}
