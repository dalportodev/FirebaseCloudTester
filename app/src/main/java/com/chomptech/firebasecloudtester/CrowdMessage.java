package com.chomptech.firebasecloudtester;

import com.firebase.client.Firebase;

/**
 * Created by Chris on 6/2/2016.
 */
public class CrowdMessage extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
