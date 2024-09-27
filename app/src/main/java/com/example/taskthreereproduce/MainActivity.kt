package com.example.taskthreereproduce

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.model.query.Where
import com.amplifyframework.core.model.temporal.Temporal
import com.amplifyframework.datastore.generated.model.Priority
import com.amplifyframework.datastore.generated.model.Todo
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
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
//        val date = Date()
//        val offsetMillis = TimeZone.getDefault().getOffset(date.time).toLong()
//        val offsetSeconds = TimeUnit.MILLISECONDS.toSeconds(offsetMillis).toInt()
//        val temporalDateTime = Temporal.DateTime(date, offsetSeconds)
//        val item = Todo.builder()
//            .name("Finish quarterly taxes")
//            .priority(Priority.HIGH)
//            .completedAt(temporalDateTime)
//            .build()
//
//
//        Amplify.DataStore.save(item,
//            { Log.i("Tutorial", "Saved item: ${item.name}") },
//            { Log.e("Tutorial", "Could not save item to DataStore", it) }
//        )

//        Amplify.DataStore.query(Todo::class.java,
//            { todos ->
//                while (todos.hasNext()) {
//                    val todo: Todo = todos.next()
//                    Log.i("Tutorial", "==== Todo ====")
//                    Log.i("Tutorial", "Name: ${todo.name}")
//                    todo.priority?.let { todoPriority -> Log.i("Tutorial", "Priority: $todoPriority") }
//                    todo.completedAt?.let { todoCompletedAt -> Log.i("Tutorial", "CompletedAt: $todoCompletedAt") }
//                }
//            },
//            {
//                Log.e("Tutorial", "Could not query DataStore", it)
//            }
//        )


//        Amplify.DataStore.query(Todo::class.java, Where.matches(Todo.PRIORITY.eq(Priority.HIGH)),
//            { todos ->
//                while (todos.hasNext()) {
//                    val todo: Todo = todos.next()
//                    Log.i("Tutorial", "==== Todo ====")
//                    Log.i("Tutorial", "Name: ${todo.name}")
//                    todo.priority?.let { todoPriority -> Log.i("Tutorial", "Priority: $todoPriority") }
//                    todo.completedAt?.let { todoCompletedAt -> Log.i("Tutorial", "CompletedAt: $todoCompletedAt") }
//                }
//            },
//            {
//                Log.e("Tutorial", "Could not query DataStore", it)
//            }
//        )

//        Amplify.DataStore.query(Todo::class.java, Where.matches(Todo.NAME.eq("Finish quarterly taxes")),
//            { matches ->
//                if(matches.hasNext()) {
//                    val todo = matches.next()
//                    val updatedTodo = todo.copyOfBuilder()
//                        .name("File quarterly taxes")
//                        .build()
//                    Amplify.DataStore.save(updatedTodo,
//                        { Log.i("Tutorial", "Updated item: ${updatedTodo.name}") },
//                        { Log.e("Tutorial", "Update failed.", it) }
//                    )
//                }
//            },
//            {
//                Log.e("Tutorial", "Query failed", it)
//            }
//        )

//        Amplify.DataStore.query(Todo::class.java, Where.matches(Todo.NAME.eq("File quarterly taxes")),
//            { matches ->
//                if (matches.hasNext()) {
//                    val toDeleteTodo = matches.next()
//                    Amplify.DataStore.delete(toDeleteTodo,
//                        {Log.i("Tutorial", "Deleted item: $toDeleteTodo.name")},
//                        {Log.e("Tutorial", "Deleted failed", it)}
//                    )
//                }
//            },
//            {
//                Log.e("Tutorial", "Query failed.", it)
//            }
//        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskThreeReproduceTheme {
        Greeting("Android")
    }
}