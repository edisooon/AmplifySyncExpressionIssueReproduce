package com.example.taskthreereproduce

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.query.Page
import com.amplifyframework.core.model.query.Where
import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.generated.model.Comment
import com.amplifyframework.datastore.generated.model.Post
import com.amplifyframework.datastore.generated.model.PostEditor
import com.amplifyframework.datastore.generated.model.PostStatus
import com.amplifyframework.datastore.generated.model.Priority
import com.amplifyframework.datastore.generated.model.Student
import com.amplifyframework.datastore.generated.model.Todo
import com.amplifyframework.datastore.generated.model.User
import com.example.taskthreereproduce.ui.theme.TaskThreeReproduceTheme
import java.util.Date
import java.util.TimeZone
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskThreeReproduceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        Button(onClick={clearLocalStorage()}) {
                            Text("Clear")
                        }
                        Button(onClick={startSyncing()}) {
                            Text("Start syncing (>=2004)")
                        }
                        Button(onClick={changeSyncExpression()}) {
                            Text("Change Sync Expression (>=1997)")
                        }
                    }
                }
            }
        }
    }

    private fun startSyncing() {
        Amplify.DataStore.start({}, {})
    }

    private fun clearLocalStorage() {
        Amplify.DataStore.clear({}, {})
    }

    private fun changeSyncExpression() {
        StudentFilter.year = 1997
        Amplify.DataStore.stop(
            {
                Amplify.DataStore.start(
                    {}, {}
                )
            },
            {}
        )
    }
}