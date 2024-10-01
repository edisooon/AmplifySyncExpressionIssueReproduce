package com.example.taskthreereproduce

import android.app.Application
import android.util.Log
import com.amplifyframework.AmplifyException
import com.amplifyframework.api.aws.AWSApiPlugin
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.AWSDataStorePlugin
import com.amplifyframework.datastore.DataStoreConfiguration
import com.amplifyframework.datastore.generated.model.Student
import java.util.concurrent.TimeUnit

class MyAmplifyApp : Application(){

    override fun onCreate() {
        super.onCreate()
        try {
            Amplify.addPlugin(AWSApiPlugin())
            Amplify.addPlugin(AWSDataStorePlugin.builder().dataStoreConfiguration(
                DataStoreConfiguration.builder()
//                    .syncInterval(0, TimeUnit.SECONDS)
                    .syncExpression(Student::class.java) {
                        val predicate = Student.YEAR.ge(StudentFilter.year)
                        StudentFilter.isMale?.let { Student.IS_MALE.eq(StudentFilter.isMale) }
                        predicate
                    }.build()
            ).build())
            Amplify.configure(applicationContext)

            Log.i("Tutorial", "Initialized Amplify")
        } catch (error: AmplifyException) {
            Log.e("Tutorial", "Could not initialize Amplify", error)
        }
    }
}