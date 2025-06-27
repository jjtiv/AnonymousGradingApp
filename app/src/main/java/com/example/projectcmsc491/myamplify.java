package com.example.projectcmsc491;

import android.app.Application;

import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult;
import com.amplifyframework.auth.options.AuthSignOutOptions;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.AWSDataStorePlugin;


public class myamplify extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try{
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.addPlugin(new AWSDataStorePlugin());
            Amplify.configure(getApplicationContext());
        }catch (Exception e){
            e.printStackTrace();
        }

        AuthSignOutOptions options = AuthSignOutOptions.builder()
                .globalSignOut(true)
                .build();

        Amplify.Auth.signOut(options, signOutResult -> {});

    }
}
