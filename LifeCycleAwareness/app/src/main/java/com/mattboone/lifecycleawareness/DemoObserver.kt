package com.mattboone.lifecycleawareness

import com.mattboone.lifecycleawareness.ui.main.MainViewModel
import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.LifecycleOwner

class DemoObserver: LifecycleObserver {
    private val LOG_TAG = "DemoObserver"
    //I cannot get these methods to interact with my LiveData in MainViewModel
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(): String {
        Log.i(LOG_TAG, "onResume")
        return ("onResume was fired on " + java.util.Calendar.getInstance())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(): String {
        Log.i(LOG_TAG, "onPause")
        return ("onPause was fired on " + java.util.Calendar.getInstance())
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(): String {
        Log.i(LOG_TAG, "onCreate")
        return ("onCreate was fired on " + java.util.Calendar.getInstance())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(): String {
        Log.i(LOG_TAG, "onStart")
        return ("onStart was fired on " + java.util.Calendar.getInstance())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(): String {
        Log.i(LOG_TAG, "onStop")
        return ("onStop was fired on " + java.util.Calendar.getInstance())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(): String {
        Log.i(LOG_TAG, "onDestroy")
        return ("onDestroy was fired on " + java.util.Calendar.getInstance())
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {
        Log.i(LOG_TAG, owner.lifecycle.currentState.name)
    }
}