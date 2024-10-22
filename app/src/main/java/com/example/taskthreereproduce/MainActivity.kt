package com.example.taskthreereproduce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Student
import com.example.taskthreereproduce.ui.theme.TaskThreeReproduceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskThreeReproduceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        Button(onClick = { clearLocalStorage() }) {
                            Text("Clear")
                        }
                        Button(onClick = { startSyncing() }) {
                            Text("Start syncing (>=2004)")
                        }
                        Button(onClick = { storeLocalStudent() }) {
                            Text("Save a Student")
                        }
                        Button(onClick = { changeSyncExpression() }) {
                            Text("Change Sync Expression (>=1997)")
                        }
                    }
                }
            }
        }
    }

    private fun startSyncing() {
        Amplify.DataStore.start({}, {})
        Amplify.DataStore.query(Student::class.java, {}, {})
    }

    private fun storeLocalStudent() {
        val student =
            Student
                .builder()
                .name("Edison")
                .year(1999)
                .isMale(true)
                .build()
        Amplify.DataStore.save(student, {}, {})
    }

    private fun clearLocalStorage() {
        Amplify.DataStore.clear({}, {})
    }

    private fun changeSyncExpression() {
        StudentFilter.year = 1997
        Amplify.DataStore.stop(
            {
                Amplify.DataStore.start(
                    {},
                    {},
                )
            },
            {},
        )
    }
}
