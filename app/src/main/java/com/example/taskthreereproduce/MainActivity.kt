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
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
//        getStarted()
//        dataStoreSetupGuide()
//        dataStoreManipulatingDataGuide()
//        relationalModelsGuide()
        reproduceError()
    }
}

fun reproduceError() {
    // create students
//    val student = Student.builder()
//        .name("B")
//        .year(2001)
//        .isMale(true)
//        .build()
//    Amplify.DataStore.save(student,
//        {
//            Log.i("MyApp", "student saved")
//        },
//        {
//            Log.e("MyApp", "save failed", it)
//        }
//    )

    // pull student

//    Amplify.DataStore.clear(
//        {
//            Log.i("MyAmplifyApp", "DataStore cleared")
//        },
//        {
//            Log.e("MyAmplifyApp", "Error clearing DataStore")
//        }
//    )

//    Amplify.DataStore.clear(
//        {
//            Amplify.DataStore.start(
//                { Log.i("MyAmplifyApp", "DataStoreStarted") },
//                { Log.e("MyAmplifyApp", "Error starting DataStore") }
//            )
//        },
//        {
//            Log.e("MyAmplifyApp", "Error clearing DataStore: ", it)
//        }
//    )
//
    Amplify.DataStore.stop(
        {
            Amplify.DataStore.start(
                { Log.i("MyAmplifyApp", "DataStoreStarted") },
                { Log.e("MyAmplifyApp", "Error starting DataStore") }
            )
        },
        {
            Log.e("MyAmplifyApp", "Error stopping DataStore: ", it)
        }
    )

//    Amplify.DataStore.query(Student::class.java,
//        { matches ->
//            while (matches.hasNext()) {
//                val student = matches.next()
//                Log.i("MyAmplifyApp", "Student: ${student.name}")
//                Log.i("MyAmplifyApp", "Student's year: ${student.year}")
//                Log.i("MyAmplifyApp", "Student is male: ${student.isMale}")
//            }
//        },
//        {
//            Log.e("MyAmplifyApp", "Query failed", it)
//        }
//    )

}

fun relationalModelsGuide() {
    val post1 = Post.builder()
        .title("My Post with comments")
        .status(PostStatus.ACTIVE)
        .rating(10)
        .build()

    val comment = Comment.builder()
        .post(post1)
        .content("Loving Amplify DataStore!")
        .build()
    Amplify.DataStore.save(post1,
        {
            Log.i("MyAmplifyApp", "Post saved")
            Amplify.DataStore.save(comment,
                { Log.i("MyAmplifyApp", "Comment Saved") },
                { Log.e("MyAmplifyApp", "Comment not saved", it) }
            )
        },
        {
            Log.e("MyAmplifyApp", "Post not saved", it)
        }
    )

    Amplify.DataStore.query(Comment::class.java, Post.STATUS.eq(PostStatus.ACTIVE),
        { matches ->
            while (matches.hasNext()) {
                val comment = matches.next()
                Log.i("MyAmplifyApp", "Content: ${comment.content}")
            }
        },
        {
            Log.e("MyAmplifyApp", "Query failed", it)
        }
    )

    // if delete a parent object,
    // its children will be removed from the DataStore,
    // and the mutation would be synced to the cloud.
    Amplify.DataStore.query(Post::class.java, Where.identifier(Post::class.java, "123"),
        {
            if(it.hasNext()) {
                val post = it.next()
                Amplify.DataStore.delete(post,
                    {
                        Log.i("MyAmplifyApp", "Post deleted")
                    },
                    {
                        Log.e("MyAmplifyApp", "Delete failed")
                    }
                )
            }
        },
        {
            Log.e("MyAmplifyApp", "Query failed", it)
        }
    )

    val post2 = Post.builder()
        .title("My First Post")
        .status(PostStatus.ACTIVE)
        .build()
    val editor = User.builder()
        .username("Nadia")
        .build()
    val postEditor = PostEditor.builder()
        .post(post2)
        .user(editor)
        .build()
    Amplify.DataStore.save(post2,
        {
            Log.i("MyAmplifyApp", "Post saved")
            Amplify.DataStore.save(editor,
                {
                    Log.i("MyAmplifyApp", "Editor saved")
                    Amplify.DataStore.save(postEditor,
                        { Log.i("MyAmplifyApp", "PostEditor saved") },
                        { Log.e("MyAmplifyApp", "PostEditor not saved") }
                    )
                },
                {
                    Log.e("MyAmplifyApp", "Editor not saved", it)
                }
            )
        },
        {
            Log.e("MyAmplifyApp", "Post not saved", it)
        }
    )
}

fun dataStoreManipulatingDataGuide() {
    val post = Post.builder()
        .title("My First Post")
        .status(PostStatus.ACTIVE)
        .rating(10)
        .build()
    Amplify.DataStore.save(post,
        { Log.i("MyAmplifyApp", "Saved a post") },
        { Log.e("MyAmplifyApp", "Saved failed", it) }
    )

    Amplify.DataStore.query(Post::class.java,
        { matches ->
            while(matches.hasNext()) {
                val post = matches.next()
                Log.i("MyAmplifyApp", "=== query result ===")
                Log.i("MyAmplifyApp", "Post name: ${post.title}")
                Log.i("MyAmplifyApp", "Post status: ${post.status}")
                post.rating?.let { Log.i("MyAmplifyApp", "Post rating: ${post.rating}") }
                post.content?.let { Log.i("MyAmplifyApp", "Post content: ${post.content}") }
            }
        },
        {
            Log.e("MyAmplifyApp", "Query failed", it)
        }
    )

    Amplify.DataStore.query(Post::class.java, Where.identifier(Post::class.java, "123"),
        { matches ->
            if(matches.hasNext()) {
                val original = matches.next()
                val edited = original.copyOfBuilder()
                    .title("New Title")
                    .build()
                Amplify.DataStore.save(edited,
                    { Log.i("MyAmplifyApp", "Updated a post") },
                    { Log.e("MyAmplifyApp", "Update failed", it) }
                )
            }
        },
        {
            Log.e("MyAmplifyApp", "Query failed", it)
        }
    )

    Amplify.DataStore.query(Post::class.java, Where.identifier(Post::class.java, "123"),
        { matches ->
            if (matches.hasNext()) {
                val post = matches.next()
                Amplify.DataStore.delete(post,
                    {Log.i("MyAmplifyApp", "Deleted a post.")},
                    {Log.e("MyAmplifyApp", "Delete failed.", it)
                    }
                )
            }
        },
        {
            Log.e("MyAmplifyApp", "Query Failed.", it)
        }
    )

    Amplify.DataStore.query(Post::class.java,
        { matches ->
            if (matches.hasNext()) {
                val post = matches.next()
                Amplify.DataStore.delete(post, Where.matches(Post.RATING.gt(4)).queryPredicate,
                    {
                        Log.i("MyAmplifyApp", "Deleted a post.")
                    },
                    {
                        Log.e("MyAmplifyApp", "Delete failed.", it)
                    }
                )
            }
        },
        {
            Log.e("MyAmplifyApp", "Query Failed.", it)
        }
    )

    Amplify.DataStore.query(
        Post::class.java,
        Where.matches(
            Post.RATING.gt(4).or(Post.STATUS.eq(PostStatus.ACTIVE))
        ),
        { posts ->
            while (posts.hasNext()) {
                val post = posts.next()
                Log.i("MyAmplifyApp", "Post: $post")
            }
        },
        {
            Log.e("MyAmplifyApp", "Query failed", it)
        }
    )

    Amplify.DataStore.query(Post::class.java,
        Where.sorted(Post.RATING.ascending()),
        { posts ->
            while(posts.hasNext()) {
                val post = posts.next()
                Log.i("MyAmplifyApp", "Title: ${post.title}")
            }
        },
        {
            Log.e("MyAmplifyApp", "Query failed", it)
        })

    Amplify.DataStore.query(Post::class.java,
        Where.sorted(Post.RATING.ascending(), Post.TITLE.descending()),
        { posts ->
            while (posts.hasNext()) {
                val post = posts.next()
                Log.i("MyAmplifyApp", "Title: ${post.title}")
            }
        },
        {
            Log.e("MyAmplifyApp", "Query failed", it)
        }
    )

    Amplify.DataStore.query(Post::class.java,
        Where.matchesAll().paginated(Page.startingAt(0).withLimit(100)),
        { posts ->
            while(posts.hasNext()) {
                val post = posts.next()
                Log.i("MyAmplifyApp", "Title: ${post.title}")
            }
        },
        {
            Log.e("MyAmplifyApp", "Query Failed", it)
        }
    )
}

fun dataStoreSetupGuide() {
    val post = Post.builder()
        .title("Create an Amplify DataStore app")
        .status(PostStatus.ACTIVE)
        .build()
    Amplify.DataStore.save(post,
        { Log.i("MyAmplifyApp", "Created a new post successfully") },
        { Log.e("MyAmplifyApp", "Error creating post", it) })

    Amplify.DataStore.query(Post::class.java,
        { matches ->
            if (matches.hasNext()) {
                Log.i("MyAmplifyApp", "Successful query, found posts.")
            }else{
                Log.i("MyAmplifyApp", "Successful query, but no posts")
            }
        },
        {
            Log.e("MyAmplifyApp", "Error retrieving posts", it)
        }
    )
}

fun getStarted() {
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
//
        Amplify.DataStore.query(Todo::class.java,
            { todos ->
                while (todos.hasNext()) {
                    val todo: Todo = todos.next()
                    Log.i("Tutorial", "==== Todo ====")
                    Log.i("Tutorial", "Name: ${todo.name}")
                    todo.priority?.let { todoPriority -> Log.i("Tutorial", "Priority: $todoPriority") }
                    todo.completedAt?.let { todoCompletedAt -> Log.i("Tutorial", "CompletedAt: $todoCompletedAt") }
                }
            },
            {
                Log.e("Tutorial", "Could not query DataStore", it)
            }
        )
//
//
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
//
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
//
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
//
//        Amplify.DataStore.observe(Todo::class.java,
//            { Log.i("Tutorial", "Observation began") },
//            {
//                val todo = it.item()
//                Log.i("Tutorial", "Todo: $todo")
//            },
//            {
//                Log.e("Tutorial", "Observation failed", it)
//            },
//            {
//                Log.i("Tutorial", "Observation complete")
//            }
//        )
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