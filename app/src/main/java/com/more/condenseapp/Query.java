package com.more.condenseapp;

public class Query {
    /**
     * Name of the client
     */
    private String mName;

    /**
     * Email of the client
     */
    private String mEmail;

    /**
     * Phone Number of the client
     */
    private String mPhoneNumber;

    /**
     * Query Description
     */
    private String mQueryDescription;

    public Query() {
    }

    public Query(String mName, String mEmail, String mPhoneNumber, String mQueryDescription) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.mPhoneNumber = mPhoneNumber;
        this.mQueryDescription = mQueryDescription;
    }

    public String getmName() {
        return mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public String getmQueryDescription() {
        return mQueryDescription;
    }
}
