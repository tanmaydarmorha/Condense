package com.more.condenseapp;

public class Project {
    /**
     * Image resource ID of the project
     */
    private int mProjectImageId;

    /**
     * Title of the project
     */
    private int mTitle;

    /**
     * Description of the project
     */
    private int mDescription;

    /**
     * @param projectImageId gives the image resource ID of the project
     * @param title          gives the string resource ID of title of the project
     * @param description    gives the string resource ID of description of the project
     */
    public Project(int projectImageId, int title, int description) {
        mProjectImageId = projectImageId;
        mTitle = title;
        mDescription = description;
    }

    /**
     * @return the project image resource ID of the project
     */
    public int getmProjectImageId() {
        return mProjectImageId;
    }

    /**
     * @return the title string resource ID of the project
     */
    public int getmTitle() {
        return mTitle;
    }

    /**
     * @return the description resource ID of the project
     */
    public int getmDescription() {
        return mDescription;
    }

}
