package com.more.condenseapp;

public class Service {
    /**
     * Image resource ID of the service
     */
    private int mServiceImage;

    /**
     * Title of the service
     */
    private int mTitle;

    /**
     * Description of the service
     */
    private int mDescription;

    /**
     * Creates a new Service object
     *
     * @param serviceImage gives the drawable resource ID for the service
     * @param title        gives the title of the service
     * @param description  gives the description of the service
     */
    public Service(int serviceImage, int title, int description) {
        mServiceImage = serviceImage;
        mTitle = title;
        mDescription = description;
    }

    public int getmServiceImageID() {
        return mServiceImage;
    }

    public int getmTitle() {
        return mTitle;
    }

    public int getmDescription() {
        return mDescription;
    }
}
