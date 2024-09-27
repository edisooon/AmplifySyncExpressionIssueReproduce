package com.example.taskthreereproduce

import android.util.Log
import com.amplifyframework.core.Action
import com.amplifyframework.core.Amplify
import com.amplifyframework.core.Consumer
import com.amplifyframework.core.async.Cancelable
import com.amplifyframework.core.model.query.ObserveQueryOptions
import com.amplifyframework.datastore.DataStoreException
import com.amplifyframework.datastore.DataStoreQuerySnapshot
import com.amplifyframework.datastore.generated.model.Post

class ObserveExampleKit {

    val tag = "ObserveQuery"
    var post: Post? = null

    fun observeExample() {
        val options = ObserveQueryOptions()
        val observationStarted =
            Consumer { _: Cancelable ->
                Log.d(tag, "success on cancelable")
            }
        val onQuerySnapshot =
            Consumer { value: DataStoreQuerySnapshot<Post> ->
                Log.d(tag, "Post updated")
                post = value.items[0]
            }
        val onObservationError =
            Consumer { value: DataStoreException ->
                Log.d(tag, "error on snapshot $value")
            }
        val onObservationComplete = Action {
            Log.d(tag, "complete")
        }


        Amplify.DataStore.observeQuery(
            Post::class.java,
            options,
            observationStarted,
            onQuerySnapshot,
            onObservationError,
            onObservationComplete
        )
    }

    fun save() {
        // called from a UI event, for example:
        post?.let {
            Amplify.DataStore.save(
                it.copyOfBuilder().title("new title").build(),
                {Log.i(tag, "Post saved")},
                {Log.i(tag, "Error saving post")}
            )
        }
    }
}