package com.soto.criminallntent.model;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Soto on 16/5/10.
 */
public class Crime {

    private String mTitle;

    private UUID mId;

    private Date mDate;

    private boolean mSolved;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

    public Crime()
    {

        mId = UUID.randomUUID();
        setDate(new Date());
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }
}
