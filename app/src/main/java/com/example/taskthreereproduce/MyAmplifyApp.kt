package com.example.taskthreereproduce

import android.app.Application
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.AWSDataStorePlugin

class MyAmplifyApp : Application(){

    override fun onCreate() {
        super.onCreate()
        try {
            Amplify.addPlugin(AWSApiPlugin())
            Amplify.addPlugin(AWSDataStorePlugin())
            Amplify.configure(applicationContext)

            Log.i("Tutorial", "Initialized Amplify")
        } catch (error: AmplifyException) {
            Log.e("Tutorial", "Could not initialize Amplify", error)
        }
    }
}